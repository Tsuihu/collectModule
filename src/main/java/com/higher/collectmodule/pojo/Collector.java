package com.higher.collectmodule.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
//采集人员
public class Collector {
    private Integer collectorId;
    private  String tel;      //手机号，用于登录
    private  String idcard;      //采集员身份证
    private  String name;      //采集员姓名
    private  String password;      //密码
    private  Integer organizationId;      //所属机构
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date registTime;       //注册时间

}
