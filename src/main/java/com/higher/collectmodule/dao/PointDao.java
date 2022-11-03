package com.higher.collectmodule.dao;

import com.higher.collectmodule.pojo.Point;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PointDao {

    /**
     * 查询所有检测点
     * @return
     */
    List<Point> getAllPoint();

    /**
     *
     * 单查返回地点id
     * @return
     */
    Point getIdByName(@Param("pointName")String pointName);
    int nameCount(@Param("pointName")String pointName);

    /**
     * 模糊查询
     * @param pointName
     * @return
     */
    List<String> getLikeName(@Param("pointName")String pointName);
}
