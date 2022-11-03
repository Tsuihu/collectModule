package com.higher.collectmodule.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
//采集试管
public class Testtube {
    private Integer testtubeId; //试管id
    private  String testtubeCode;//试管码
    private Integer boxId; //转运箱ID
    private  Integer collectType;//采集类型，1：单采。10，10人采，20，20人采集
    private Integer status; //0：采集中，1：一封管。2：检测完成
    private String testResult;//检测结果
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date openTime; //开管时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date closeTime; //关管时间
}
