package com.xunqi.gulimall.product.fallback;

import com.xunqi.common.exception.BizCodeEnum;
import com.xunqi.common.utils.R;
import com.xunqi.gulimall.product.feign.SeckillFeignService;
import com.xunqi.gulimall.product.feign.WareFeignService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description:
 * @Created: with IntelliJ IDEA.
 * @author: 夏沫止水
 * @createTime: 2020-07-13 14:45
 **/

@Component
public class WareFeignServiceFallBack implements WareFeignService {

    @Override
    public R getSkuHasStock(List<Long> skuIds) {
        return R.error(BizCodeEnum.TO_MANY_REQUEST.getCode(),BizCodeEnum.TO_MANY_REQUEST.getMessage());
    }
}
