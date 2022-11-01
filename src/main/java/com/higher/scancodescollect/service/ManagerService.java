package com.higher.scancodescollect.service;

import com.higher.scancodescollect.exception.BusinessException;
import com.higher.scancodescollect.pojo.Manager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Service
@Component
public interface ManagerService {
    public Manager login(String tel, String password) throws BusinessException;
}
