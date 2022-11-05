package com.higher.collectmodule.service.impl;

import com.higher.collectmodule.dao.PeopleDao;
import com.higher.collectmodule.exception.BusinessException;
import com.higher.collectmodule.pojo.People;
import com.higher.collectmodule.pojo.Testtube;
import com.higher.collectmodule.service.PeopleService;
import com.higher.collectmodule.util.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class PeopleServiceImpl implements PeopleService {
    @Autowired
    PeopleDao peopleDao;

    @Override
    public List<People> getPeopleByTubeId(Integer testtubeId) {
        List<People> peopleList = peopleDao.getPeopleByTubeId(testtubeId);

        return peopleList;
    }

    @Override
    public void addPeople(People people) throws BusinessException {
        Integer peopleId = peopleDao.getpeopleByIdcard(people.getIdcard());
//        查不到peopleID，则进行人员的添加
        if (StringUtils.isEmpty(peopleId)){
            peopleDao.addPeople(people);
        }
        else {
            throw new BusinessException("人员信息已经添加过了", ResultCodeEnum.ERROR);
        }
        //查的到peopleId,则根据查到的peopleId进行sample表的人员和试管的绑定

    }

    @Override
    public void insertSample(Integer peopleId, Integer testtubeId) {
        peopleDao.insertSample(peopleId,testtubeId);
    }

//    @Override
//    public Integer getTypeByTubeId(Integer testtubeId) {
//        Integer type = peopleDao.getTypeByTubeId(testtubeId);
//        return type;
//    }
}
