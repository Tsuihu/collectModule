package com.higher.collectmodule.controller;

import com.higher.collectmodule.exception.BusinessException;
import com.higher.collectmodule.pojo.Collector;
import com.higher.collectmodule.service.CollectorService;
import com.higher.collectmodule.util.ResultCodeEnum;
import com.higher.collectmodule.util.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/collector")
public class CollectorController {
    @Autowired
    CollectorService collectorService;

    /**
     * 登录接口
     * @param collector
     * @return
     * @throws BusinessException
     */

    @PostMapping("/login.do")
    ResultModel<Collector> login(@RequestBody Collector collector) throws BusinessException {
        Collector login = collectorService.login(collector.getTel(), collector.getPassword());
        return  new ResultModel<>(ResultCodeEnum.SUCCESS, login, "");
    }

    /**
     * 注册接口
     * @param collector
     * @return
     * @throws BusinessException
     */
    @PostMapping("registe.do")
    ResultModel<Collector> registe(@RequestBody Collector collector) throws BusinessException {
        collector.setRegistTime(new Date());
        collector.setOrganizationId("1000");
        collectorService.addManager(collector);
        return new ResultModel<>(ResultCodeEnum.SUCCESS,collector,"");
    }
}
