package com.ums.api;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: wenTaoDong
 * @Date: 2022/3/6 03-06 22:10
 * @Description: com.ums.api
 * @Version 1.0
 */
@Data
@Builder
public class ResultVo<T> implements Serializable, Comparable<T> {
    //状态码
    private int code;
    private String message;
    private T data;

    public static ResultVo.ResultVoBuilder getSuccessBuilder() {
        return ResultVo.builder().
                code(ResponseCode.SUCCESS.getCode())
                .message(ResponseCode.SUCCESS.getMessage());
    }

    public static ResultVo.ResultVoBuilder getFailBuilder() {
        return ResultVo.builder().
                code(ResponseCode.NO_MESSAGE_AVAILABLE.getCode())
                .message(ResponseCode.NO_MESSAGE_AVAILABLE.getMessage());
    }

    @Override
    public int compareTo(T o) {
        return 0;
    }
}
