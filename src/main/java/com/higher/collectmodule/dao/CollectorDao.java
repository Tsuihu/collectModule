package com.higher.collectmodule.dao;

import com.higher.collectmodule.pojo.Collector;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.management.StandardEmitterMBean;

@Component
public interface CollectorDao {

  Collector login(String tel);
}
