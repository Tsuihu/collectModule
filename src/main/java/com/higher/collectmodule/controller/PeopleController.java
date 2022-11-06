package com.higher.collectmodule.controller;

import com.higher.collectmodule.dao.PeopleDao;
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

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("people")
public class PeopleController {
    @Autowired
    PeopleService peopleService;

    @Autowired
    PeopleDao peopleDao;

    /**
     * 根据试管Id查询所有peopleId，再根据peopleID查询对应的人员信息
     * @param testtubeId 前端保存testtubeId，后端调用
     * @return
     */
    @PostMapping("getAllPeople.do")
    ResultModel<List<People>> getPeopleByTubeId(HttpServletRequest request,Integer testtubeId){
        List<People> peopleList = peopleService.getPeopleByTubeId(testtubeId);
        request.getSession().setAttribute("testtubeId",testtubeId);
        return new ResultModel<>(ResultCodeEnum.SUCCESS,peopleList,"");
    }

    /**
     * 仅添加人员信息，
     * @param people 人员的name,idcardType,idcard,tel
     * @return
     * @throws BusinessException
     */
    @PostMapping("addPeople.do")
    ResultModel<People> addPeople(HttpServletRequest request, @RequestBody People people) throws BusinessException {

        peopleService.addPeople(people);
        Integer peopleId1 = (Integer) request.getSession().getAttribute("peopleId");
        Integer tubeId = (Integer) request.getSession().getAttribute("testtubeId");
        Integer type = peopleService.getTypeByTubeId(tubeId);
        List<People> peopleList = peopleService.getPeopleByTubeId(tubeId);
        int size = peopleList.size();//10
        if (size<type){
            peopleService.insertSample(peopleId1,tubeId,new Date());
            return  new ResultModel<>(ResultCodeEnum.SUCCESS, people, "添加成功");
        }
        else {
            return new ResultModel<>(ResultCodeEnum.ERROR,people,"试管已满，请封管后另开新管检测");
        }

    }

}
