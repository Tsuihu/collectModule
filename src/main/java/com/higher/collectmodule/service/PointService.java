package com.higher.collectmodule.service;

import com.higher.collectmodule.exception.BusinessException;
import com.higher.collectmodule.pojo.Point;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PointService {

    //显示所有检测点
    List<Point> getAllPoint();


    //模糊查询
    List<Point> getLikeName(String pointName);
}
