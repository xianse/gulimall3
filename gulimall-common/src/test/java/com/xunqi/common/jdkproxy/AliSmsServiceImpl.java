package com.xunqi.common.jdkproxy;

public class AliSmsServiceImpl implements AliSmsService{
    @Override
    public void send(String message) {
        System.out.println("send:"+message);
    }
}
