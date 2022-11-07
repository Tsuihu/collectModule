package com.higher.collectmodule.dao;

import com.higher.collectmodule.pojo.Collector;
import com.higher.collectmodule.pojo.bo.CollectorMsg;
import org.springframework.stereotype.Component;


@Component
public interface CollectorDao {
  //登录

  Collector login(String tel);

  // 注册
  void addManager(CollectorMsg collectorMsg);
  // 检查手机号是否存在
  int checkCollectorRepeat(String tel);
}
