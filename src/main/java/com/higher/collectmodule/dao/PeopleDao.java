package com.higher.collectmodule.dao;

import com.higher.collectmodule.pojo.People;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface PeopleDao {
    //查询试管里全部人员信息
    List<People> getPeopleByTubeId(@Param("testtubeId") Integer testtubeId);


    //添加人员信息
    void addPeople(People people);

    //根据身份证查peopleId,判断人员是都存在
    Integer getpeopleByIdcard(@Param("idcard") String idcard);


    void insertSample(@Param("peopleId") Integer peopleId,@Param("testtubeId") Integer testtubeId);

    Integer getTypeByTubeId(@Param("testtubeId") Integer testtubeId);
}
