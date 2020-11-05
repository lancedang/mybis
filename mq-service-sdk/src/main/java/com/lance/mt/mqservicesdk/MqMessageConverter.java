// Copyright (C) 2020 Meituan
// All rights reserved
package com.lance.mt.mqservicesdk;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.stereotype.Component;

/**
 * @author qiankai07
 * @version 1.0
 * Created on 11/4/20 11:51 AM
 **/
public class MqMessageConverter extends SimpleMessageConverter {

    private static final String orgKey = "org";
    private static final String userNameKey = "username";

    @Override
    public Object fromMessage(Message message) throws MessageConversionException {

        //todo, 重新threadlocal设置org, username等
        return super.fromMessage(message);
    }

    @Override
    protected Message createMessage(Object object, MessageProperties messageProperties) throws MessageConversionException {

        messageProperties.setHeader(orgKey, ContextHolder.getOrg());
        messageProperties.setHeader(userNameKey, ContextHolder.getUserName());

        return super.createMessage(object, messageProperties);
    }
}