package com.mebay.template.handler;

import com.mebay.template.base.CommonResult;
import com.mebay.template.enums.BizCodeEnum;
import com.mebay.template.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;

/**
 * 全局异常处理
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @PostConstruct
    public void init (){
        log.info("===================GlobalExceptionHandler init ==================================");
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public CommonResult handleException(Exception e) {
        log.error("程序运行出现异常：{}",e);
        return CommonResult.failed(BizCodeEnum.FAILED,"程序运行出现异常!");
    }

    /**
     * 业务异常全局处理器
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(BizException.class)
    public CommonResult<String> handleBizException(BizCodeEnum e) {
        log.error("程序运行出现异常：{}",e);
        return CommonResult.failed(e.getCode(),e.getMessage());
    }
}
