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
    @Override
    public List<Box> getAllBox() {
        List<Box> allBox = boxDao.getAllBox();
        return allBox;
    }
}
