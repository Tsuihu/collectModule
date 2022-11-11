package com.higher.collectmodule.service.impl;

import com.higher.collectmodule.dao.CollectorDao;
import com.higher.collectmodule.exception.BusinessException;
import com.higher.collectmodule.pojo.Collector;
import com.higher.collectmodule.pojo.bo.CollectorMsg;
import com.higher.collectmodule.service.CollectorService;
import com.higher.collectmodule.util.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectorServiceImpl implements CollectorService {
    @Autowired
    CollectorDao collectorDao;

    /**
     * 登录
     * @param tel
     * @param password
     * @return
     * @throws BusinessException
     */
    @Override
    public Collector login(String tel, String password) throws BusinessException{
        Collector login = collectorDao.login(tel);
        System.out.println(login);
        if(login == null){
            throw new BusinessException("手机号不存在", ResultCodeEnum.LOGIN_ERROR);
        }
        if(login.getPassword()!=null&&login.getPassword().equals(password)){
            return login;
        }
        throw new BusinessException("密码错误",ResultCodeEnum.LOGIN_ERROR);
    }

    /**
     * 注册
     * @param collectorMsg
     * @throws BusinessException
     */
    @Override
    public void addManager(CollectorMsg collectorMsg) throws BusinessException {

        if(collectorDao.checkCollectorIdCard(collectorMsg.getIdcard()) > 0) {
            throw new BusinessException("身份证已存在",ResultCodeEnum.ERROR);
        }else {
            if (collectorDao.checkCollectorRepeat(collectorMsg.getTel()) > 0) {
                throw new BusinessException("手机号已存在", ResultCodeEnum.ERROR);
            } else {
                collectorDao.addManager(collectorMsg);
            }
        }
    }
}
