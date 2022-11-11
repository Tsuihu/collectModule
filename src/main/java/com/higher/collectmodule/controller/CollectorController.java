package com.higher.collectmodule.controller;

import com.higher.collectmodule.dao.CollectorDao;
import com.higher.collectmodule.exception.BusinessException;
import com.higher.collectmodule.pojo.Collector;
import com.higher.collectmodule.pojo.Point;
import com.higher.collectmodule.pojo.bo.CollectorMsg;
import com.higher.collectmodule.service.CollectorService;
import com.higher.collectmodule.util.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
@RequestMapping("/collector")
public class CollectorController {
    @Autowired
    CollectorService collectorService;

    @Autowired
    CollectorDao collectorDao;

    /**
     * 登录接口
     * @param collector
     * @return
     * @throws BusinessException
     */

    @PostMapping("/login.do")
    ResultModel<Collector> login(@RequestBody Collector collector) throws BusinessException {
        //密码进行MD5加密后查询登录
        String passwordMd5 = MD5.encrypt(collector.getPassword());
        System.out.println(passwordMd5);

        Collector login = collectorService.login(collector.getTel(),passwordMd5);
        return  new ResultModel<>(ResultCodeEnum.SUCCESS, login, "登录成功");
    }


    /**
     * 发送手机短信息验证码
     *
     * @param collector
     * @return
     */
    @PostMapping("/sendMsg.do")
    public ResultModel<String> sendMsg(@RequestBody Collector collector, HttpSession session) throws BusinessException {
        String idcard = collector.getIdcard();
        if (idcard.length()!=18){
            throw new BusinessException("身份证长度不正确，请重新输入",ResultCodeEnum.ERROR);
        }
        //获取手机号
        String tel = collector.getTel();

        //判断当前手机号对应的用户是否为新用户，如果是新用户就自动完成注册
        int i = collectorDao.checkCollectorRepeat(tel);
        if (i>0){
            throw new BusinessException("手机号已存在，请重新输入",ResultCodeEnum.ERROR);
        }

        if (tel!=null) {
            //生成随机的4位验证码
            String code = ValidateCodeUtils.generateValidateCode(4).toString();

            //调用阿里云提供的短信服务API完成发送短信
//            SMSUtils.sendMessage("阿里云短信测试", "SMS_154950909", tel, code);
            //需要将生成验证码保存到session
            log.info("code:{}",code);
            session.setAttribute("tel", tel);
            session.setAttribute("code", code);


            return new ResultModel(ResultCodeEnum.SUCCESS,"验证码发送成功");
        }
        return new ResultModel(ResultCodeEnum.ERROR,"验证码发送失败");
    }


    /**
     * 注册接口
     * @param collectorMsg
     * @return
     * @throws BusinessException
     */
    @PostMapping("registe.do")
    ResultModel<Collector> registe(@RequestBody CollectorMsg collectorMsg,HttpSession session) throws BusinessException {

        String idcard = collectorMsg.getIdcard();
        System.out.println(idcard.length());

        log.info(collectorMsg.toString());
        //获取手机号
        String tel = collectorMsg.getTel();

        //获取验证码
        String code = collectorMsg.getCode();

        System.out.println(code);

        //从session中获取保存的验证码
        Object codeInSession = session.getAttribute("code");

        //进行验证码的比对（页面提交的验证码和session中保存的验证码对比）
        if (codeInSession !=null && codeInSession.equals(code)){
            //如果比对成功，说明登录成功

                //密码进行MD5加密
                String password = collectorMsg.getPassword();
                String signKeyMd5 = MD5.encrypt(password);
                collectorMsg.setPassword(signKeyMd5);

                collectorMsg.setRegistTime(new Date());
                collectorMsg.setOrganizationId(1000);
                collectorService.addManager(collectorMsg);
            }
            return new ResultModel<>(ResultCodeEnum.SUCCESS,collectorMsg,"注册成功");
        }



}
