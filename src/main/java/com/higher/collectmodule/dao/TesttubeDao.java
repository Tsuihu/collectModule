package com.higher.collectmodule.dao;

import com.higher.collectmodule.pojo.Testtube;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public interface TesttubeDao {
//    查询全部管的信息,参数是boxId
    List<Testtube> getAllTube(@Param("boxId")Integer boxId);
//    开管
    void addTube(Testtube testtube);
//    判断编号是否重复
    int getOne(@Param("testtubeCode") String testtubeCode);
//    封管,传递参数是开管时的testtubeId,
    void closeTube(@Param("status")Integer status, @Param("closeTime")Date closeTime,@Param("testtubeId")Integer testtubeId);
}
