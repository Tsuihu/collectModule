package com.higher.collectmodule.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
// 采集员实体类
public class Manager {
    private Integer managerId;
    private String name;
    private String idcard;
    private String tel;
    private String password;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date registeTime;

    @Override
    public String toString() {
        return "Manager{" +
                "managerId=" + managerId +
                ", name='" + name + '\'' +
                ", idcard='" + idcard + '\'' +
                ", tel='" + tel + '\'' +
                ", password='" + password + '\'' +
                ", registeTime=" + registeTime +
                '}';
    }
}
