package com.higher.collectmodule.dao;

import com.higher.collectmodule.pojo.Box;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BoxDao {

    //查询所有箱子
    List<Box> getAllBox(Integer pointId);

    //开箱操作
    void addBox(Box box);

    //封箱操作
    void closeBox(Box box);

    //获取单个箱子的行数
    Box getBoxCode(String boxCode);
}
