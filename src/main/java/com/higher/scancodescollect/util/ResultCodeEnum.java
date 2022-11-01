package com.higher.scancodescollect.util;

/**
 * 封装返回数据
 */
public enum ResultCodeEnum {
    SUCCESS(0),ERROR(100),LOGIN_ERROR(101);

    private int code;
    ResultCodeEnum(int i) {
        this.code = i;
    }
    public int getCode() {
        return code;
    }
}
