package com.higher.collectmodule.service;

import com.higher.collectmodule.exception.BusinessException;
import com.higher.collectmodule.pojo.People;
import com.higher.collectmodule.pojo.Testtube;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PeopleService {
    //    查询试管里全部人员信息
    List<People> getPeopleByTubeId(Integer testtubeId);

    //添加人员信息
    void addPeople(People people) throws BusinessException;

    void insertSample(Integer peopleId, Integer testtubeId);

//    Integer getTypeByTubeId(@Param("testtubeId") Integer testtubeId);
}
