package com.higher.collectmodule.controller;

import com.higher.collectmodule.exception.BusinessException;
import com.higher.collectmodule.pojo.Box;
import com.higher.collectmodule.service.BoxService;
import com.higher.collectmodule.util.ResultCodeEnum;
import com.higher.collectmodule.util.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/box")
public class BoxController {
    @Autowired
    BoxService boxService;

    @PostMapping("getAllBox.do")
    ResultModel<List<Box>> getAllBox(Integer pointId){
        List<Box> allBox = boxService.getAllBox(pointId);
        return new ResultModel<>(ResultCodeEnum.SUCCESS,allBox,"");
    }


    @PostMapping("addBox.do")
    ResultModel<Box> addBox(HttpServletRequest request,@RequestBody Box box) throws BusinessException {
        if (box.getBoxCode() == null){
            throw new BusinessException("请输入正确编码",ResultCodeEnum.ERROR);
        }
        box.setStatus("0");//状态，0：开箱，1：封箱
        box.setCollectorId((Integer) request.getSession().getAttribute("login"));
//        box.setCollectorId(1);//检测人员Id，和前端合并后修改为前端获取
        box.setTransferId(1);//转运人员默认1
        box.setTesterId(1);//检测人员Id，默认值1
        box.setPointId(1);//检测点Id，和前端合并后修改为前端获取
        box.setTestOrganiationId(1);//检测机构Id，默认值1
        box.setOpenTime(new Date());//开箱时间，获取当前时间
        boxService.addBox(box);
        return new ResultModel<>(ResultCodeEnum.SUCCESS,box,"开箱成功");
    }
}
