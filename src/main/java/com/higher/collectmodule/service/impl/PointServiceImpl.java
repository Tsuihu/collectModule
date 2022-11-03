package com.higher.collectmodule.service.impl;

import com.higher.collectmodule.dao.PointDao;
import com.higher.collectmodule.exception.BusinessException;
import com.higher.collectmodule.pojo.Point;
import com.higher.collectmodule.service.PointService;
import com.higher.collectmodule.util.ResultCodeEnum;
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
    /**
     * 查询地址的id
     * @return
     */
    @Override
    public Point getIdByName(String pointName) throws BusinessException {
        if (pointDao.nameCount(pointName)==0){
            throw new BusinessException("地点信息不存在", ResultCodeEnum.POINT_ERROR);
        }else {
            Point idByName = pointDao.getIdByName(pointName);
            return idByName;
        }
    }
    /**
     * 模糊查询
     * @return
     */
    @Override
    public List<String> getLikeName(String pointName) {
        List<String> points = pointDao.getLikeName(pointName);
        return points;
    }
}
