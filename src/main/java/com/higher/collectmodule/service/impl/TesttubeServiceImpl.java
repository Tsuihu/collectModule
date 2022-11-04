package com.higher.collectmodule.service.impl;

import com.higher.collectmodule.dao.TesttubeDao;
import com.higher.collectmodule.exception.BusinessException;
import com.higher.collectmodule.pojo.Testtube;
import com.higher.collectmodule.service.TesttubeService;
import com.higher.collectmodule.util.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TesttubeServiceImpl implements TesttubeService {
    @Autowired
    TesttubeDao testtubeDao;
//  查询箱下面的所有管的编码和状态,需要传递开箱时的boxId
    @Override
    public List<Testtube> getAllTube(Integer boxId) {
        List<Testtube> allTube = testtubeDao.getAllTube(boxId);
        return allTube;
    }

    /**
     * 开管,需要传递开箱时的boxId,输入的开管编码testtubeCode,和选择采集类型的1，10或者20(collectType)
     * @param testtube
     * @throws BusinessException
     */
    @Override
    public void addTube(Testtube testtube) throws BusinessException {
//        进行判断，查看箱子状态是否封箱，若封箱则不能继续添加试管
        if (testtubeDao.getBoxStatus(testtube.getBoxId().toString()).equals("1")){
            throw new BusinessException("此箱已封箱，不能继续添加试管", ResultCodeEnum.LOGIN_ERROR);
        }
//        进行判断,看看试管编码是否重复
        else if (testtubeDao.getOne(testtube.getTesttubeCode())>0){
            throw new BusinessException("编号已存在", ResultCodeEnum.LOGIN_ERROR);
        }
        testtubeDao.addTube(testtube);
    }

    /**
     * 封管,需要传递开管时的testtubeId
     * @param status
     * @param closeTime
     * @param testtubeId
     */
    @Override
    public void closeTube(Integer status, Date closeTime,int testtubeId) {
        testtubeDao.closeTube(status,closeTime,testtubeId);
    }
}
