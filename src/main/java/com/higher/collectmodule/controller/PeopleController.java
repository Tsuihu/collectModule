package com.higher.collectmodule.controller;

import com.higher.collectmodule.exception.BusinessException;
import com.higher.collectmodule.pojo.People;
import com.higher.collectmodule.pojo.Sample;
import com.higher.collectmodule.pojo.Testtube;
import com.higher.collectmodule.service.PeopleService;
import com.higher.collectmodule.util.ResultCodeEnum;
import com.higher.collectmodule.util.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("people")
public class PeopleController {
    @Autowired
    PeopleService peopleService;

    /**
     * 根据试管Id查询所有peopleId，再根据peopleID查询对应的人员信息
     * @param testtubeId 前端保存testtubeId，后端调用
     * @return
     */
    @PostMapping("getAllPeople.do")
    ResultModel<List<People>> getPeopleByTubeId(Integer testtubeId){
        List<People> peopleList = peopleService.getPeopleByTubeId(testtubeId);
//        System.out.println(peopleList.size());

        return new ResultModel<>(ResultCodeEnum.SUCCESS,peopleList,"");
    }

    /**
     * 仅添加人员信息，
     * @param people 人员的name,idcardType,idcard,tel
     * @return
     * @throws BusinessException
     */
    @PostMapping("addPeople.do")
    ResultModel<People> addPeople(@RequestBody People people) throws BusinessException {
        people.setCreateTime(new Date());
        peopleService.addPeople(people);
        return new ResultModel<>(ResultCodeEnum.SUCCESS,people,"");
    }

    /**
     * 根据人员信息添加sample表，
     * @param people peopleId
     * @param sample
     * @param testtube  testtubeId,collectType.
     * @return
     */
    @PostMapping("insertSample.do")
    ResultModel<Sample> insertSample(People people,Sample sample,Testtube testtube){
        Integer type = testtube.getCollectType();
        List<People> peopleList = peopleService.getPeopleByTubeId(testtube.getTesttubeId());
        int size = peopleList.size();
        if (size<type){
            sample.setCollectTime(new Date());
            peopleService.insertSample(people.getPeopleId(), testtube.getTesttubeId());
            return new ResultModel<>(ResultCodeEnum.SUCCESS,sample,"添加成功");
        }
       else {
           return new ResultModel<>(ResultCodeEnum.ERROR,"试管已满，请封管后另开新管检测");
        }
    }

}
