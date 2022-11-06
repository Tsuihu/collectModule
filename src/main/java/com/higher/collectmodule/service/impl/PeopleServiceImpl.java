package com.higher.collectmodule.service.impl;

import com.higher.collectmodule.dao.PeopleDao;
import com.higher.collectmodule.exception.BusinessException;
import com.higher.collectmodule.pojo.People;
import com.higher.collectmodule.service.PeopleService;
import com.higher.collectmodule.util.ResultCodeEnum;
import com.higher.collectmodule.util.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Service
public class PeopleServiceImpl implements PeopleService {
    @Autowired
    PeopleDao peopleDao;

    @Autowired
    HttpServletRequest request;

    @Override
    public List<People> getPeopleByTubeId(Integer testtubeId) {
        List<People> peopleList = peopleDao.getPeopleByTubeId(testtubeId);

        return peopleList;
    }

    @Override
    public void addPeople(People people) throws BusinessException {

        people.setCreateTime(new Date());
        Integer peopleId2 = peopleDao.getpeopleByIdcard(people.getIdcard());
        if (peopleId2 == null){
            peopleDao.addPeople(people);
        }
        Integer peopleId = peopleDao.getpeopleByIdcard(people.getIdcard());
        request.getSession().setAttribute("peopleId",peopleId);
        Integer tubeId = (Integer) request.getSession().getAttribute("testtubeId");

        String getstatus = peopleDao.getstatusByTubeId(tubeId);
        if (getstatus.equals("1")){
            throw new BusinessException("此管已封，请另开新管添加",ResultCodeEnum.ERROR);
        }


    }

    @Override
    public void insertSample(Integer peopleId, Integer testtubeId, Date collectTime) {

        peopleDao.insertSample(peopleId,testtubeId,collectTime);
    }

    @Override
    public Integer getTypeByTubeId(Integer testtubeId) {
        Integer type = peopleDao.getTypeByTubeId(testtubeId);
        return type;
    }

}
