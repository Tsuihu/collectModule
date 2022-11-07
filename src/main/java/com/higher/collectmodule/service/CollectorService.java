package com.higher.collectmodule.service;

import com.higher.collectmodule.exception.BusinessException;
import com.higher.collectmodule.pojo.Collector;
import com.higher.collectmodule.pojo.bo.CollectorMsg;
import org.springframework.stereotype.Component;

@Component
public interface CollectorService {
    //登录
    Collector login(String tel, String password) throws BusinessException;

    //注册
    void addManager(CollectorMsg collectorMsg)throws BusinessException;
}
