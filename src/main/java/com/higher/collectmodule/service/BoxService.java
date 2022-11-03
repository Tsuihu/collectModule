package com.higher.collectmodule.service;

import com.higher.collectmodule.pojo.Box;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BoxService {
    List<Box> getAllBox();
}
