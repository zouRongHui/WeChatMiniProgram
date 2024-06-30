package com.rone.controller;

import com.rone.exception.ParamException;
import com.rone.exception.RoneException;
import com.rone.qo.ReceiveRightsQO;
import com.rone.qo.RightsActivityFindByIdQO;
import com.rone.service.RightsActivityService;
import com.rone.vo.Result;
import com.rone.vo.RightsActivityVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * 权益活动配置
 *
 * @author rone
 */
@RestController
@RequestMapping("/rightsActivity")
@Api(description = "权益活动信息接口")
public class RightsActivityController {

    public static final Logger LOGGER = LoggerFactory.getLogger(RightsActivityController.class);

    @Autowired
    private RightsActivityService service;

    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    @ApiOperation(value = "根据id来获取权益信息")
    public Result<RightsActivityVO> pointsQuery(@RequestBody RightsActivityFindByIdQO qo) throws ParamException {
        if (qo == null || qo.getId() == null) {
            return Result.fault("无此活动或活动未开始！");
        }
        return Result.success(service.findVOById(qo));
    }

    @RequestMapping(value = "/receiveRights", method = RequestMethod.POST)
    @ApiOperation(value = "领取权益")
    public Result receiveRights(@RequestBody ReceiveRightsQO qo) throws RoneException, IOException, URISyntaxException {
        if (StringUtils.isEmpty(qo.getSessionId()) || StringUtils.isEmpty(qo.getMobileNo())
                || StringUtils.isEmpty(qo.getSmsAuthCode()) || qo.getRightsId() == null) {
            return Result.fault("领取失败，缺少必备的参数！");
        }
        service.receiveRights(qo);
        return Result.success("领取成功！");
    }
}
