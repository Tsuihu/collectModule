package com.higher.scancodescollect.controller;

import com.higher.scancodescollect.exception.BusinessException;
import com.higher.scancodescollect.pojo.Manager;
import com.higher.scancodescollect.pojo.bo.LoginModel;
import com.higher.scancodescollect.service.ManagerService;
import com.higher.scancodescollect.util.ResultCodeEnum;
import com.higher.scancodescollect.util.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    ManagerService managerService;

    @PostMapping("login.do")
    public ResultModel<Manager> login(@RequestBody LoginModel model) throws BusinessException {
        Manager manager = managerService.login(model.getTel(), model.getPassword());
        //上面的方法只要不报错，就是调用成功，可以直接返回。
        return new ResultModel<>(ResultCodeEnum.SUCCESS, manager, "");
    }
}
