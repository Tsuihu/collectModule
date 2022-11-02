package com.higher.collectmodule.util;

import lombok.Data;

@Data
/**
 * 封装返回数据结果
 */
public class ResultModel<T> {
    private Integer code;
    private T data;
    private String errMsg;

    public ResultModel(ResultCodeEnum codeEnum, T data, String errMsg) {
        this.code = codeEnum.getCode();
        this.data = data;
        this.errMsg = errMsg;
    }
}
