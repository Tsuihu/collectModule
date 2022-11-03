package com.higher.collectmodule.dao;

import com.higher.collectmodule.pojo.Manager;
import org.springframework.stereotype.Component;

//@Repository
@Component
public interface ManagerDao {
    // 登录
    public Manager getManagerByTel(Long tel);
    // 注册
    public void addManager(Manager manager);
    // 检查手机号是否存在
    int checkManagerRepeat(Long tel);
}
