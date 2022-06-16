package com.xunqi.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xunqi.common.utils.PageUtils;
import com.xunqi.gulimall.product.entity.UndoLogEntity;

import java.util.Map;

/**
 * 
 *
 * @author czl
 * @email 1335781235@qq.com
 * @date 2022-05-22 15:57:06
 */
public interface UndoLogService extends IService<UndoLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

