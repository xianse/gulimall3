package com.xunqi.gulimall.member.fallback;

import com.xunqi.common.exception.BizCodeEnum;
import com.xunqi.common.utils.R;
import com.xunqi.gulimall.member.feign.OrderFeignService;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Description:
 * @Created: with IntelliJ IDEA.
 * @author: 夏沫止水
 * @createTime: 2020-07-13 14:45
 **/

@Component
public class OrderFeignServiceFallBack implements OrderFeignService {

    @Override
    public R listWithItem(Map<String, Object> params) {
        return R.error(BizCodeEnum.TO_MANY_REQUEST.getCode(),BizCodeEnum.TO_MANY_REQUEST.getMessage());
    }
}
