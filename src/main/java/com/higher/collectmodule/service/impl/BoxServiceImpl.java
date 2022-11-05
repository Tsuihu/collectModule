package com.higher.collectmodule.service.impl;

import com.higher.collectmodule.dao.BoxDao;
import com.higher.collectmodule.pojo.Box;
import com.higher.collectmodule.service.BoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class BoxServiceImpl implements BoxService {

    @Autowired
    BoxDao boxDao;

    /**
     * 查询所有箱子
     * @param pointId
     * @return allBox
     */
    @Override
    public List<Box> getAllBox(Integer pointId) {
        List<Box> allBox = boxDao.getAllBox(pointId);
        return allBox;
    }

    /**
     * 开箱操作
     * @param box boxCode,collectorId,pointId
     */
    @Override
    public void addBox(Box box){
            boxDao.addBox(box);
    }

    /**
     * 封箱操作
     * @param box status,closeTime
     */
    @Override
    public void closeBox(Box box) {
        boxDao.closeBox(box);
    }
}
