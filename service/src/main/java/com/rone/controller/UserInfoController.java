package com.rone.controller;

import com.rone.annotation.NeedLogon;
import com.rone.exception.RoneException;
import com.rone.qo.CommonQO;
import com.rone.service.UserInfoService;
import com.rone.vo.Result;
import com.rone.vo.UserInfoVO;
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
 * 用户信息获取
 *
 * @author rone
 */
@RestController
@RequestMapping("/userInfo")
@Api(description = "获取用户信息")
public class UserInfoController {

    public static final Logger LOGGER = LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/userInfo", method = RequestMethod.POST)
    @ApiOperation(value = "获取用户信息(需要登陆)")
    @NeedLogon
    public Result<UserInfoVO> userInfo(@RequestBody CommonQO qo) throws Exception {
        return Result.success(userInfoService.userInfo(qo));
    }

    @RequestMapping(value = "/userToken", method = RequestMethod.POST)
    @ApiOperation(value = "获取用户Token令牌(需要登陆)")
    @NeedLogon
    public Result<String> userToken(@RequestBody CommonQO qo) throws RoneException {
        return Result.success("", userInfoService.userToken(qo));
    }

}
