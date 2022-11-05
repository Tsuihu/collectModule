package com.higher.collectmodule.service.impl;

import com.higher.collectmodule.dao.PeopleDao;
import com.higher.collectmodule.exception.BusinessException;
import com.higher.collectmodule.pojo.People;
import com.higher.collectmodule.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
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
            peopleDao.addPeople(people);
    }

    @Override
    public void insertSample(Integer peopleId, Integer testtubeId) {

        peopleDao.insertSample(peopleId,testtubeId);
    }

    @Override
    public Integer getTypeByTubeId(Integer testtubeId) {
        Integer type = peopleDao.getTypeByTubeId(testtubeId);
        return type;
    }

}
