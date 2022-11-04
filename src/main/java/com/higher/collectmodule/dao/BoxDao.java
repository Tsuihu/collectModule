package com.higher.collectmodule.dao;

import com.higher.collectmodule.pojo.Box;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BoxDao {
    List<Box> getAllBox(Integer pointId);

    void addBox(Box box);

}
