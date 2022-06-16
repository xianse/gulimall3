package com.xunqi.common.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInVocationHandler implements InvocationHandler {
    private Object target;
    public MyInVocationHandler(Object target){
        this.target=target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before:"+method.getName());
        Object invoke = method.invoke(target, args);
        System.out.println("after:"+method.getName());

        return invoke;
    }
}
