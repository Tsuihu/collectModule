package com.higher.scancodescollect.dao;

import com.higher.scancodescollect.pojo.Manager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Repository
@Component
public interface ManagerDao {
    public Manager getManagerByTel(String tel);
}
