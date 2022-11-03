package com.higher.collectmodule.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
//移动端采集人员实体类
public class Collector {
    private Integer collectorId;
    private String name;
    private Long tel;
    private String password;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+8")
    private Date createTime;

    @Override
    public String toString() {
        return "collector{" +
                "collectorId=" + collectorId +
                ", name='" + name + '\'' +
                ", tel=" + tel +
                ", password='" + password + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
