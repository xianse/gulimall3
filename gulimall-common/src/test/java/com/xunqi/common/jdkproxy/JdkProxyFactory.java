package com.xunqi.common.jdkproxy;

import java.lang.reflect.Proxy;

public class JdkProxyFactory {
    public static Object getProxy(Object target){
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new MyInVocationHandler(target));

    }
}
