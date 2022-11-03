package com.higher.collectmodule.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
// 运营管理人员表
public class Manager {
    private Integer managerId;
    private String name;  //管理员姓名
    private String idcard; //身份证号，可用于找回密码
    private String tel;   //电话，可用于登录
    private String password; //密码
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date registTime; //注册时间


    @Override
    public String toString() {
        return "Manager{" +
                "managerId=" + managerId +
                ", name='" + name + '\'' +
                ", idcard='" + idcard + '\'' +
                ", tel='" + tel + '\'' +
                ", password='" + password + '\'' +
                ", registeTime=" + registTime +
                '}';
    }
}
