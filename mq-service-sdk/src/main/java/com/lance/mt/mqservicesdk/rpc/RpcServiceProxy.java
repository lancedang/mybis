// Copyright (C) 2020 Meituan
// All rights reserved
package com.lance.mt.mqservicesdk.rpc;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.lang.reflect.Proxy;

/**
 * @author qiankai07
 * @version 1.0
 * Created on 11/4/20 5:18 PM
 * 返回接口类
 **/
public class RpcServiceProxy<T> implements FactoryBean, InitializingBean {

    private Class                             serviceClass;

    private String                            queueName;

    @Autowired
    private AmqpTemplate                      amqpTemplate;

    private RpcServiceProxyInvocationHandler rpcServiceProxyInvocationHandler = new RpcServiceProxyInvocationHandler();

    @PostConstruct
    public void init() {
        rpcServiceProxyInvocationHandler.setAmqpTemplate(amqpTemplate);
        rpcServiceProxyInvocationHandler.setQueueName(queueName);
    }

    @Override
    public T getObject() {
        return (T) Proxy.newProxyInstance(serviceClass.getClassLoader(),
            new Class[] { serviceClass }, rpcServiceProxyInvocationHandler);
    }

    @Override
    public Class<?> getObjectType() {
        return serviceClass;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("after properties set ");
    }

    public Class getServiceClass() {
        return serviceClass;
    }

    public void setServiceClass(Class serviceClass) {
        this.serviceClass = serviceClass;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }
}