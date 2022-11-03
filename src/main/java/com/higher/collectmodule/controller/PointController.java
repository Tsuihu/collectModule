package com.higher.collectmodule.controller;

import com.higher.collectmodule.pojo.Point;
import com.higher.collectmodule.service.PointService;
import com.higher.collectmodule.util.ResultCodeEnum;
import com.higher.collectmodule.util.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/point")
public class PointController {

    @Autowired
    PointService pointService;

    /**
     * 查询所有的检测点
     * @return
     */
    @PostMapping("getAllPoint.do")
    ResultModel<List<Point>> getAllPoint(){
        List<Point> allPoint = pointService.getAllPoint();
        return new ResultModel<>(ResultCodeEnum.SUCCESS,allPoint,"");
    }
}
