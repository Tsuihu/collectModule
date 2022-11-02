package com.higher.collectmodule.service;

import com.higher.collectmodule.exception.BusinessException;
import com.higher.collectmodule.pojo.Collector;
import org.springframework.stereotype.Component;

@Component
public interface CollectorService {
    Collector login(String tel, String password) throws BusinessException;
}
