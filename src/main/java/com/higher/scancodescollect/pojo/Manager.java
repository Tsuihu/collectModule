package com.higher.scancodescollect.pojo;

import lombok.Data;

import java.util.Date;


@Data
public class Manager {
    private Integer managerId;
    private String name;
    private String idcard;
    private String tel;
    private String password;
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
