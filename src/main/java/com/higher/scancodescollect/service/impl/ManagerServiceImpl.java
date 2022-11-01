package com.higher.scancodescollect.service.impl;

import com.higher.scancodescollect.dao.ManagerDao;
import com.higher.scancodescollect.exception.BusinessException;
import com.higher.scancodescollect.pojo.Manager;
import com.higher.scancodescollect.service.ManagerService;
import com.higher.scancodescollect.util.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Service
@Component
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    ManagerDao managerDao;
    @Override
    public Manager login(String tel, String password) throws BusinessException {
        Manager manager = managerDao.getManagerByTel(tel);
        if(manager == null){
            throw new BusinessException("手机号不存在", ResultCodeEnum.LOGIN_ERROR);
        }
        if(manager.getPassword()!=null&&manager.getPassword().equals(password)){
            return manager;
        }
        throw new BusinessException("密码错误",ResultCodeEnum.LOGIN_ERROR);
    }
}
