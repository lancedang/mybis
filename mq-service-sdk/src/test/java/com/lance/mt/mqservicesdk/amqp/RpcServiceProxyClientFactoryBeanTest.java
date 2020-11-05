package com.lance.mt.mqservicesdk.amqp;

import com.lance.mt.mqservicesdk.rpc.RpcServiceClientInvocationHandler;
import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * Author: 钱凯
 * Date: 11/4/20.
 */
public class RpcServiceProxyClientFactoryBeanTest {

    @Test
    public void getObject() {
        Runnable o = (Runnable)Proxy.newProxyInstance(RpcServiceProxyClientFactoryBeanTest.class.getClassLoader(), new Class[]{Runnable.class}, new RpcServiceClientInvocationHandler());
        o.run();
    }
}