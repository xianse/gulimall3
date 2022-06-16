package com.xunqi.gulimall.gateway.config;

import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.GatewayCallbackManager;
import com.alibaba.fastjson.JSON;
import com.xunqi.common.exception.BizCodeEnum;
import com.xunqi.common.utils.R;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @Description:
 * @Created: with IntelliJ IDEA.
 * @author: 夏沫止水
 * @createTime: 2020-07-13 17:18
 **/

@Configuration
public class SentinelGatewayConfig {

    public SentinelGatewayConfig() {
        //网关限流了请求，就会调用此回调
        GatewayCallbackManager.setBlockHandler((exchange, t) -> {

            R error = R.error(BizCodeEnum.TO_MANY_REQUEST.getCode(), BizCodeEnum.TO_MANY_REQUEST.getMessage());
            String errorJson = JSON.toJSONString(error);

            Mono<ServerResponse> body = ServerResponse.ok().body(Mono.just(errorJson), String.class);
            return body;
        });
    }

}
