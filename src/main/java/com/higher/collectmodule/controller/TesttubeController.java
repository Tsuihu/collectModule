package com.higher.collectmodule.controller;

import com.higher.collectmodule.exception.BusinessException;
import com.higher.collectmodule.pojo.Testtube;
import com.higher.collectmodule.service.TesttubeService;
import com.higher.collectmodule.util.ResultCodeEnum;
import com.higher.collectmodule.util.ResultModel;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/testtube")
public class TesttubeController {
    @Autowired
    TesttubeService testtubeService;

    /**
     *查询全部管的信息，包含管编号和状态,需要前端返回开箱时的boxId
     * @return
     */
    @PostMapping("/getAllTube.do")
    public ResultModel<List<Testtube>> getAllTube(HttpServletRequest request,Testtube testtube){
        List<Testtube> testtubes= testtubeService.getAllTube(testtube.getBoxId());



        return new ResultModel<>(ResultCodeEnum.SUCCESS, testtubes, "");
    }

    /**
     * 开管，，需要前端返回开箱的boxId,以及输入的管编码testtubeCode，和选择采集类型的1，10或者20(collectType)
     * @param testtube
     * @return
     * @throws BusinessException
     */
    @PostMapping("/addTube.do")
    public ResultModel<Testtube> addTube(HttpServletRequest request,@RequestBody Testtube testtube) throws BusinessException {
        testtube.setStatus(0);
        testtube.setOpenTime(new Date());
        testtube.setTestResult("0");
        testtubeService.addTube(testtube);
//        request.getSession().setAttribute("tubeId",testtube.getTesttubeId());
//        request.getSession().setAttribute("tubeType",testtube.getCollectType());
        return new ResultModel<Testtube>(ResultCodeEnum.SUCCESS, testtube, "");
    }

    /**
     *封管，需要返回前端开管时的testtubeId
     * @param testtube
     * @return
     */
    @PostMapping("/closeTube.do")
    public ResultModel<Testtube> closeTube(@RequestBody Testtube testtube){
        testtube.setStatus(1);
        testtube.setCloseTime(new Date());
        testtubeService.closeTube(testtube.getStatus(),testtube.getCloseTime(),testtube.getTesttubeId());
        return new ResultModel<>(ResultCodeEnum.SUCCESS, testtube, "");
    }
}
