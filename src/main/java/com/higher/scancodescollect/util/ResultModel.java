package com.higher.scancodescollect.util;

import lombok.Data;

@Data
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
