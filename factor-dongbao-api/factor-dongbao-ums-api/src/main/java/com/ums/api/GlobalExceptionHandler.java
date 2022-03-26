package com.ums.api;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: wenTaoDong
 * @Date: 2022/3/6 03-06 22:59
 * @Description: com.ums.api
 * @Version 1.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResultVo.ResultVoBuilder customException() {
        return ResultVo.builder().code(301).message("统一异常处理");
    }
}
