package org.rone.study.springBoot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.rone.study.springBoot.async.AsyncTest;
import org.rone.study.springBoot.model.Result;
import org.rone.study.springBoot.model.User;
import org.rone.study.springBoot.model.ViewLog;
import org.rone.study.springBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by rone on 2018/4/26.
 */
@RestController
@RequestMapping("/test")
@Api(value = "测试接口", description = "测试Demo")
@EnableAsync
public class TestController {

    @Autowired
    private UserService userService;
    @Autowired
    private AsyncTest asyncTest;

    @RequestMapping(value = "/asyncTest")
    @ApiOperation(value = "异步线程", notes = "异步线程的请求测试")
    public Result<?> testAsync() {
        int length = 30;
        for (int i = 0; i < length; i++) {
            System.out.println(i + " 主线程调用....");
            asyncTest.test(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i + " 调用完成....");
        }
        return Result.success();
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ApiOperation(value = "纯测试请求", notes = "仅仅是为了测试请求是否能通")
    public Result<?> test() {
        return Result.success(new ViewLog("test.", new Date()));
//        return Result.success("测试请求成功！");
    }

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    @ApiOperation(value = "获取用户列表")
    public Result<?> getUsers() {
        try {
            return Result.success(userService.getUsers());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fault(e.getMessage(), e);
        }
    }

    @RequestMapping(value = "/getUserById/{userId}", method = RequestMethod.GET)
    @ApiOperation(value = "根据用户Id获取用户信息")
    public Result<?> getUserById(@PathVariable("userId") String userId) {
        try {
            return Result.success(userService.getUserById(userId));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fault(e.getMessage(), e);
        }
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.PUT)
    @ApiOperation(value = "新增用户")
    public Result<?> addUser(@RequestBody User user) {
        try {
            userService.addUser(user);
            return Result.success(user);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fault(e.getMessage(), e);
        }
    }

    @RequestMapping(value = "/updateUserName", method = RequestMethod.PUT)
    @ApiOperation(value = "根据Id更改用户名")
    public Result<?> updateUserName(@RequestParam("userId") String userId,
                                 @RequestParam("userName") String name) {
        try {
            return Result.success(userService.updateUserName(userId, name));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fault(e.getMessage(), e);
        }
    }

    @RequestMapping(value = "/getUserByName/{userName}", method = RequestMethod.GET)
    @ApiOperation(value = "根据用户名获取用户信息")
    public Result<?> getUserByName(@PathVariable("userName") String name) {
        try {
            return Result.success(userService.getUserByName(name));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fault(e.getMessage(), e);
        }
    }

    @RequestMapping(value = "/getUserPartDataByName/{userName}", method = RequestMethod.GET)
    @ApiOperation(value = "根据用户名获取用户部分信息")
    public Result<?> getUserPartDataByName(@PathVariable("userName") String name) {
        try {
            return Result.success(userService.getUserPartDataByName(name));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fault(e.getMessage(), e);
        }
    }
    @RequestMapping(value = "/getUserPartDataListByName/{userName}", method = RequestMethod.GET)
    @ApiOperation(value = "根据用户名获取用户部分信息列表")
    public Result<?> getUserPartDataListByName(@PathVariable("userName") String name) {
        try {
            return Result.success(userService.getUserPartDataListByName(name));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fault(e.getMessage(), e);
        }
    }

    @RequestMapping(value = "/updateUserEmailByName", method = RequestMethod.PUT)
    @ApiOperation(value = "根据用户名更改邮箱")
    public Result<?> updateUserEmailByName(@RequestParam("userName") String name, @RequestParam("email") String email) {
        try {
            userService.updateUserEmailByName(name, email);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fault(e.getMessage(), e);
        }
    }

}
