package com.higher.collectmodule.service;

import com.higher.collectmodule.exception.BusinessException;
import com.higher.collectmodule.pojo.Box;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BoxService {

//    查询所有箱子，List接收
    List<Box> getAllBox(Integer pointId);

//    开箱操作
    void addBox(Box box) throws BusinessException;

//    封箱操作
    void closeBox(Box box);
}
