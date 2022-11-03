package com.higher.collectmodule.service;

import com.higher.collectmodule.pojo.Manager;
import com.higher.collectmodule.exception.BusinessException;
import org.springframework.stereotype.Component;

//@Service
@Component
public interface ManagerService {
    public Manager login(Long tel, String password) throws BusinessException;
    public void  addManager(Manager manager) throws BusinessException;
}
