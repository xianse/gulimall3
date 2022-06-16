package com.xunqi.common.CGLibProxy;

import org.springframework.cglib.proxy.Enhancer;

public class CglibProxyFactory {
    public static Object getProxy(Class clazz){
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new DebugMethodInterceptor());
        enhancer.setClassLoader(clazz.getClassLoader());
        return enhancer.create();
    }
}
