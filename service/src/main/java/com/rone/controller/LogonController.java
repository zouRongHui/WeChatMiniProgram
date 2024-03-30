package com.rone.controller;

import com.rone.annotation.NeedLogon;
import com.rone.qo.*;
import com.rone.service.LogonService;
import com.rone.vo.Result;
import com.rone.vo.UserInfoVO;
import com.rone.vo.WeChatLogonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户登陆
 *
 * @author rone
 */
@RestController
@RequestMapping
@Api(value = "登录接口", description = "登录接口")
public class LogonController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogonController.class);

    @Autowired
    private LogonService logonService;

    @RequestMapping(value = "/weChatLogon", method = RequestMethod.POST)
    @ApiOperation(value = "微信小程序登录")
    public Result<WeChatLogonVO> weChatLogon(@RequestBody WeChatLogonQo weChatLogonQo) throws Exception {
        return Result.success("登陆成功", logonService.weChatLogon(weChatLogonQo));
    }

    @RequestMapping(value = "/sendSMSAuthCode", method = RequestMethod.POST)
    @ApiOperation(value = "发送短信验证码")
    public Result<String> sendSMSAuthCode(@RequestBody SendSMSAuthCodeQO sendSMSAuthCodeQO) throws Exception {
        logonService.sendSMSAuthCode(sendSMSAuthCodeQO);
        return Result.success("短信验证码发送成功");
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ApiOperation(value = "注册")
    public Result<UserInfoVO> register(@RequestBody RegisterQO registerQO) throws Exception {
        return Result.success("注册成功，已登陆", logonService.register(registerQO));
    }

    @RequestMapping(value = "/logon", method = RequestMethod.POST)
    @ApiOperation(value = "登录")
    public Result<UserInfoVO> logon(@RequestBody LogonQO logonQO) throws Exception {
        return Result.success("登陆成功", logonService.logon(logonQO));
    }

    @RequestMapping(value = "/logonOut", method = RequestMethod.POST)
    @ApiOperation(value = "退出登陆(需登陆)")
    @NeedLogon
    public Result logonOut(@RequestBody CommonQO qo) throws Exception {
        logonService.logonOut(qo);
        return Result.success("已经退出登陆");
    }

}