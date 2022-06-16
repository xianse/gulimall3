package com.xunqi.gulimall.product.fallback;

import com.xunqi.common.es.SkuEsModel;
import com.xunqi.common.exception.BizCodeEnum;
import com.xunqi.common.to.SkuReductionTo;
import com.xunqi.common.to.SpuBoundTo;
import com.xunqi.common.utils.R;
import com.xunqi.gulimall.product.feign.CouponFeignService;
import com.xunqi.gulimall.product.feign.SearchFeignService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description:
 * @Created: with IntelliJ IDEA.
 * @author: 夏沫止水
 * @createTime: 2020-07-13 14:45
 **/

@Component
public class CouponFeignServiceFallBack implements CouponFeignService {



    @Override
    public R saveSpuBounds(SpuBoundTo spuBoundTo) {
        return R.error(BizCodeEnum.TO_MANY_REQUEST.getCode(),BizCodeEnum.TO_MANY_REQUEST.getMessage());
    }

    @Override
    public R saveSkuReduction(SkuReductionTo skuReductionTo) {
        return R.error(BizCodeEnum.TO_MANY_REQUEST.getCode(),BizCodeEnum.TO_MANY_REQUEST.getMessage());
    }
}
