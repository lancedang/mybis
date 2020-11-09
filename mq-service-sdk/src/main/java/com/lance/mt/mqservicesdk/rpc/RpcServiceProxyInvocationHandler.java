// Copyright (C) 2020 Meituan
// All rights reserved
package com.lance.mt.mqservicesdk.rpc;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.support.RemoteInvocation;
import org.springframework.remoting.support.RemoteInvocationResult;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author qiankai07
 * @version 1.0
 * Created on 11/4/20 4:25 PM
 * InvocationHandler 用于利用target类执行实际逻辑
 **/
public class RpcServiceProxyInvocationHandler implements InvocationHandler {

    //实际被代理的对象，这里注意，不一定是同$Proxy0同接口的类，可以是任何一个类，只要不在invoke方法中执行method.invoke(amqpTemplate, args)就行
    private AmqpTemplate amqpTemplate;

    private String       queueName;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //以MQ作为RPC，MQ中的消息只需要两方面内容：1.接口名称，2.接口参数
        String methodName = method.getName();

        RemoteInvocation remoteInvocation = new RemoteInvocation(methodName,
            method.getParameterTypes(), args);

        //构造rabbitMQ 消息
        Object result = amqpTemplate.convertSendAndReceive(queueName, remoteInvocation,
            (message) -> {
                message.getMessageProperties().getHeaders().put("org", "sh");
                return message;
            });

        System.out.println("不错" + methodName);
        return ((RemoteInvocationResult)result).recreate();
    }

    public AmqpTemplate getAmqpTemplate() {
        return amqpTemplate;
    }

    public void setAmqpTemplate(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }
}