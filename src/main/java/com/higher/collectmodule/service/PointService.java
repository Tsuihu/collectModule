package com.higher.collectmodule.service;

import com.higher.collectmodule.pojo.Point;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PointService {
    //显示所有检测点
    List<Point> getAllPoint();
}
