package com.higher.collectmodule.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
//转运箱
public class Box {
    private Integer boxId; //箱子的编号
    private  String boxCode; //转运箱码
    private  String status; //0：开箱检测，1：已封箱，2：已转运，3：检测机构已接收，4：已开始检测
    private Integer collectorId; //采集人员ID
    private Integer transferId; //转运人员ID
    private Integer testerId;//检测人员ID
    private Integer pointId; //采集点ID
    private Integer testOrganiationId; //检测机构医院ID
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date openTime; //开箱时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date closeTime; //封箱时间
}
