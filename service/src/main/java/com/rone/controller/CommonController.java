package com.rone.controller;

import com.rone.enumeration.SystemParamKeyEnum;
import com.rone.service.SysParamService;
import com.rone.vo.LaunchPageVO;
import com.rone.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 通用接口
 *
 * @author rone
 */
@RestController
@RequestMapping
@Api(description = "通用接口")
public class CommonController {

    public static final Logger LOGGER = LoggerFactory.getLogger(CommonController.class);

    @Autowired
    private SysParamService sysParamService;

    @RequestMapping(value = "/launchPageSetting", method = RequestMethod.POST)
    @ApiOperation(value = "获取启动页配置")
    public Result<LaunchPageVO> launchPageSetting() {
        LaunchPageVO launchPageVO = new LaunchPageVO();
        String picture = sysParamService.getSysParamValue(SystemParamKeyEnum.LAUNCH_PAGE_PICTURE.getCode());
        if (StringUtils.isEmpty(picture)) {
            return Result.fault("没有配置启动页参数");
        }
        String redirect = sysParamService.getSysParamValue(SystemParamKeyEnum.LAUNCH_PAGE_REDIRECT.getCode());
        redirect = redirect == null ? "" : redirect;
        int duration = 3000;
        try {
            duration = Integer.parseInt(sysParamService.getSysParamValue(SystemParamKeyEnum.LAUNCH_PAGE_DURATION.getCode()));
        } catch (NumberFormatException e) {
            LOGGER.warn("小程序启动页时常参数获取错误", e);
        }

        launchPageVO.setPicture(picture);
        launchPageVO.setRedirect(redirect);
        launchPageVO.setDuration(duration);
        return Result.success(launchPageVO);
    }
}
