// Copyright (C) 2020 Meituan
// All rights reserved
package com.lance.mt.mqservicesdk.rpc;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.support.RemoteInvocation;
import org.springframework.remoting.support.RemoteInvocationBasedExporter;
import org.springframework.remoting.support.RemoteInvocationResult;

/**
 * @author qiankai07
 * @version 1.0
 * Created on 11/5/20 5:07 PM
 **/
public class RcpServiceExporter extends RemoteInvocationBasedExporter implements MessageListener, InitializingBean {

    @Autowired
    private MessageConverter messageConverter;

    private Object proxy;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public void onMessage(Message message) {
        //调用
        Object result = messageConverter.fromMessage(message);
        RemoteInvocationResult remoteInvocationResult = invokeAndCreateResult((RemoteInvocation) result, proxy);
        MessageProperties messageProperties = message.getMessageProperties();
        String replyTo = messageProperties.getReplyTo();
        Address replyToAddress = messageProperties.getReplyToAddress();
        String correlationIdString = messageProperties.getCorrelationIdString();

        if (remoteInvocationResult.hasException()) {
            System.out.println("has exception");
        }

        MessageProperties replyMessageProperties = new MessageProperties();
        replyMessageProperties.getHeaders().putAll(message.getMessageProperties().getHeaders());


        Message toMessage = messageConverter.toMessage(remoteInvocationResult, replyMessageProperties);
        amqpTemplate.send(replyTo, toMessage);

        System.out.println("on message reply to=" + replyTo + ", reply address=" + replyToAddress + ", correlation string =" + correlationIdString);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        proxy = getProxyForService();
    }

    public AmqpTemplate getAmqpTemplate() {
        return amqpTemplate;
    }

    public void setAmqpTemplate(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }
}