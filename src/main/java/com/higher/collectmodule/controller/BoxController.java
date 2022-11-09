package com.higher.collectmodule.controller;

import com.higher.collectmodule.dao.BoxDao;
import com.higher.collectmodule.exception.BusinessException;
import com.higher.collectmodule.pojo.Box;
import com.higher.collectmodule.service.BoxService;
import com.higher.collectmodule.util.ResultCodeEnum;
import com.higher.collectmodule.util.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/box")
public class BoxController {
    @Autowired
    BoxService boxService;

    @Autowired
    BoxDao boxDao;

    /**
     * 根据pointId查询相应的所有箱子信息
     * @param pointId
     * @return
     */
    @PostMapping("getAllBox.do")
    ResultModel<List<Box>> getAllBox(Integer pointId){
        List<Box> allBox = boxService.getAllBox(pointId);
        return new ResultModel<>(ResultCodeEnum.SUCCESS,allBox,"");
    }


    /**
     *开箱操作，输入boxCode进行开箱
     * @param box boxCode,collectorId,pointId
     * @return
     * @throws BusinessException
     */
    @PostMapping("addBox.do")
    ResultModel<Box> addBox(@RequestBody Box box) throws BusinessException {
        Box boxCode = boxDao.getBoxCode(box.getBoxCode());
        if (StringUtils.isEmpty(box.getBoxCode()) || boxCode!=null){
//            return new ResultModel<>(ResultCodeEnum.ERROR,"箱子编码重复或编码输入错误，请重新输入");
            throw new BusinessException("箱子编码重复或编码输入错误，请重新输入",ResultCodeEnum.ERROR);
        }
        box.setStatus("0");//状态，0：开箱，1：封箱
        box.setTransferId(1);//转运人员默认1
        box.setTesterId(1);//检测人员Id，默认值1
        box.setTestOrganiationId(1);//检测机构Id，默认值1
        box.setOpenTime(new Date());//开箱时间，获取当前时间
        boxService.addBox(box);
        return new ResultModel<>(ResultCodeEnum.SUCCESS,box,"开箱成功");
    }

    /**
     *封箱操作
     * @param box 前端给转运箱编码
     * @return
     */
    @PostMapping("closeBox.do")
    ResultModel<Box> closeBox(Box box){
        box.setCloseTime(new Date());
        box.setStatus("1");
        boxService.closeBox(box);
        return new ResultModel<>(ResultCodeEnum.SUCCESS,box,"封箱成功");
    }
}
