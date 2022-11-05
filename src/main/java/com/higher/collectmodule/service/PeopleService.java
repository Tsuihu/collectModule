package com.higher.collectmodule.service;

import com.higher.collectmodule.exception.BusinessException;
import com.higher.collectmodule.pojo.People;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Component
public interface PeopleService {
    //    查询试管里全部人员信息
    List<People> getPeopleByTubeId(Integer testtubeId);

    //添加人员信息
    void addPeople(People people) throws BusinessException;

    void insertSample(@Param("peopleId") Integer peopleId, @Param("testtubeId") Integer testtubeId ,@Param("collectTime") Date collectTime);


    Integer getTypeByTubeId(@Param("testtubeId") Integer testtubeId);


}
