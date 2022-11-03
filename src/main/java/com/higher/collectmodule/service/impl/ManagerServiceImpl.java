package com.higher.collectmodule.service.impl;

import com.higher.collectmodule.dao.ManagerDao;
import com.higher.collectmodule.exception.BusinessException;
import com.higher.collectmodule.pojo.Manager;
import com.higher.collectmodule.service.ManagerService;
import com.higher.collectmodule.util.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Service
@Component
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    ManagerDao managerDao;

    /**
     * 登录
     * @param tel
     * @param password
     * @return manager
     * @throws BusinessException
     */
    @Override
    public Manager login(Long tel, String password) throws BusinessException {
        Manager manager = managerDao.getManagerByTel(tel);
        if(manager == null){
            throw new BusinessException("手机号不存在", ResultCodeEnum.LOGIN_ERROR);
        }
        if(manager.getPassword()!=null&&manager.getPassword().equals(password)){
            return manager;
        }
        throw new BusinessException("密码错误",ResultCodeEnum.LOGIN_ERROR);
    }

    /**
     * 注册
     * @param manager
     * @throws BusinessException
     */
    @Override
    public void addManager(Manager manager) throws BusinessException {
        if(managerDao.checkManagerRepeat(manager.getTel()) > 0) {
            throw new BusinessException("手机号已存在",ResultCodeEnum.ERROR);
        }else {
            managerDao.addManager(manager);
        }
    }
}
