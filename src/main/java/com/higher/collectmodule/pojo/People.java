package com.higher.collectmodule.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
//核酸人
public class People {
    private Integer peopleId;  //人id
    private  String name;      //人员姓名
    private  String idcardType; //证件类型：0:身份证 1：户口本 2：护照
    private  String idcard;    //身份证号
    private  String tel;       //手机号
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime; //创建时间
}
