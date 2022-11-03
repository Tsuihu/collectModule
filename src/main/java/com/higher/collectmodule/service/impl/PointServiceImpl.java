package com.higher.collectmodule.service.impl;

import com.higher.collectmodule.dao.PointDao;
import com.higher.collectmodule.pojo.Point;
import com.higher.collectmodule.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointServiceImpl implements PointService {

    @Autowired
    PointDao pointDao;

    /**
     * 查询所有检测点，用List集合
     * @return
     */
    @Override
    public List<Point> getAllPoint() {
        List<Point> allPoint = pointDao.getAllPoint();
        return  allPoint;
    }
}
