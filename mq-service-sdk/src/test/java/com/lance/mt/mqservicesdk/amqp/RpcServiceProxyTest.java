package com.lance.mt.mqservicesdk.amqp;

import com.lance.mt.mqservicesdk.rpc.RpcServiceProxyInvocationHandler;
import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * Author: 钱凯
 * Date: 11/4/20.
 */
public class RpcServiceProxyTest {

    @Test
    public void getObject() {
        Runnable o = (Runnable)Proxy.newProxyInstance(RpcServiceProxyTest.class.getClassLoader(), new Class[]{Runnable.class}, new RpcServiceProxyInvocationHandler());
        o.run();
    }
}