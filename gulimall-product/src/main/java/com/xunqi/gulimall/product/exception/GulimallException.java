package com.xunqi.gulimall.product.exception;

import com.xunqi.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@Slf4j
@RestControllerAdvice(basePackages = "com.xunqi.gulimall.product.controller")
public class GulimallException {
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
public R handle(MethodArgumentNotValidException e){
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        log.error("数据教研出现问题{},异常类型:{}", e.getMessage(),e.getClass());
        BindingResult bindingResult = e.getBindingResult();
        bindingResult.getFieldErrors().forEach((fieldError ->{
            String defaultMessage = fieldError.getDefaultMessage();
            String field = fieldError.getField();
            stringStringHashMap.put(defaultMessage,field);
        } ));
        return R.error(400,"数据校验异常").put("data", stringStringHashMap);

}
}
