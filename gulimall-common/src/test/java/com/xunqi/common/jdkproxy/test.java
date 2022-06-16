package com.xunqi.common.jdkproxy;

public class test {
    public static void main(String[] args) {
        AliSmsService aliSmsService = (AliSmsService)JdkProxyFactory.getProxy(new AliSmsServiceImpl());
        aliSmsService.send("java");
    }
}
