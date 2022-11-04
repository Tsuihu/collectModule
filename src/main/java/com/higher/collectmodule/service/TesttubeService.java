package com.higher.collectmodule.service;

import com.higher.collectmodule.exception.BusinessException;
import com.higher.collectmodule.pojo.Testtube;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public interface TesttubeService {

//  查询此箱下面的所有管信息
    List<Testtube> getAllTube(Integer boxId);
//   添加试管
    void addTube(Testtube testtube) throws BusinessException;
//  封管
    void closeTube(Integer status, Date closeTime,int testtubeId);
}
