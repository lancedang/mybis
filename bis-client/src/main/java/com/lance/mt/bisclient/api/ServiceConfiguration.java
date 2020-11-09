// Copyright (C) 2020 Meituan
// All rights reserved
package com.lance.mt.bisclient.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author qiankai07
 * @version 1.0
 * Created on 11/4/20 9:20 PM
 * 
 * 构造各种Service bean用以本地调用
 **/
@Configuration
public class ServiceConfiguration {

    @Value("${pboc.queue.name}")
    private String pbocServiceQueueName;

/*    @Bean("pbocService")
    public PbocService getPbocService() {
        RpcServiceProxyClientFactoryBean<PbocService> pbocServiceRpcServiceProxyClientFactoryBean = new RpcServiceProxyClientFactoryBean<>();

        pbocServiceRpcServiceProxyClientFactoryBean.setServiceClass(PbocService.class);
        pbocServiceRpcServiceProxyClientFactoryBean.setQueueName(pbocServiceQueueName);

        return pbocServiceRpcServiceProxyClientFactoryBean.getObject();
    }*/

}