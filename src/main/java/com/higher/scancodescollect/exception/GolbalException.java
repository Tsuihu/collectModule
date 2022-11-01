package com.higher.scancodescollect.exception;

import com.higher.scancodescollect.util.ResultCodeEnum;
import com.higher.scancodescollect.util.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice

public class GolbalException {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultModel<Object> handle(Exception e) {
        if (e instanceof Exception) {
            BusinessException be = (BusinessException) e;
            log.error("业务逻辑处理异常：{}", (be).getMessage());
            log.trace(e.getStackTrace().toString());
            e.printStackTrace();
            return new ResultModel<>(be.getResultCode(),null,be.getMessage());
        }
        log.error("系统异常：{}", e);
        return new ResultModel<>(ResultCodeEnum.ERROR,null,"系统错误");
    }
}
