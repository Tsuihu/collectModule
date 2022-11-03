package com.higher.collectmodule.controller;

import com.higher.collectmodule.exception.BusinessException;
import com.higher.collectmodule.pojo.Point;
import com.higher.collectmodule.service.PointService;
import com.higher.collectmodule.util.ResultCodeEnum;
import com.higher.collectmodule.util.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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

    /**
     * 单查返回信息id
     * @param point
     * @return2
     * @throws BusinessException
     */
    @PostMapping("/getIdByName.do")
    void getIdByName(HttpServletRequest request, @RequestBody Point point) throws BusinessException {
        Point point1 = pointService.getIdByName(point.getPointName());
        request.getSession().setAttribute("pointId",point1.getPointId());
    }

    /**
     * 模糊查询
     * @param point
     * @return
     * @throws BusinessException
     */
    @PostMapping("/getLikeName.do")
    ResultModel<List<Point>> getLikeName(@RequestBody Point point) throws BusinessException {
        List<Point> name= pointService.getLikeName(point.getPointName());
        return new ResultModel<>(ResultCodeEnum.SUCCESS,name,"");
    }
}
