package com.higher.collectmodule.service.impl;

import com.higher.collectmodule.dao.CollectorDao;
import com.higher.collectmodule.exception.BusinessException;
import com.higher.collectmodule.pojo.Collector;
import com.higher.collectmodule.service.CollectorService;
import com.higher.collectmodule.util.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectorServiceImpl implements CollectorService {
    @Autowired
    CollectorDao collectorDao;
    @Override
    public Collector login(String tel, String password) throws BusinessException{
        Collector login = collectorDao.login(tel);

        if(login == null){
            throw new BusinessException("手机号不存在", ResultCodeEnum.LOGIN_ERROR);
        }
        if(login.getPassword()!=null&&login.getPassword().equals(password)){
            return login;
        }
        throw new BusinessException("密码错误",ResultCodeEnum.LOGIN_ERROR);
    }
}
