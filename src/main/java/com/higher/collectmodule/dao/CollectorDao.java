package com.higher.collectmodule.dao;

import com.higher.collectmodule.pojo.Collector;
import com.higher.collectmodule.pojo.Manager;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import javax.management.StandardEmitterMBean;

@Component
public interface CollectorDao {
  //登录

  Collector login(String tel);

  // 注册
  void addManager(Collector collector);
  // 检查手机号是否存在
  int checkCollectorRepeat(String tel);
}
