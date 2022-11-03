package com.higher.collectmodule.controller;

import com.higher.collectmodule.pojo.Box;
import com.higher.collectmodule.service.BoxService;
import com.higher.collectmodule.util.ResultCodeEnum;
import com.higher.collectmodule.util.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping()
public class BoxController {
    @Autowired
    BoxService boxService;
    ResultModel<List<Box>> getAllBox(){
        List<Box> allBox = boxService.getAllBox();
        return new ResultModel<>(ResultCodeEnum.SUCCESS,allBox,"");
    }
}
