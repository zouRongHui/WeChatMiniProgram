package com.rone.controller;

import com.rone.constant.HttpSessionAttributeConstant;
import com.rone.enumeration.SystemParamKeyEnum;
import com.rone.exception.RoneException;
import com.rone.model.LogonUserInfo;
import com.rone.qo.CommonQO;
import com.rone.service.SysParamService;
import com.rone.session.RoneSessionContext;
import com.rone.vo.MsgInfoVo;
import com.rone.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * 小程序信息提醒
 *
 * @author rone
 */
@RestController
@RequestMapping("msg")
@Api(value = "小程序信息提醒", description = "小程序信息提醒")
public class AppMsgInfoController {

    @Autowired
    private SysParamService sysParamService;

    /**
     * 获取公告
     *
     * @param qo
     * @return
     * @throws RoneException
     */
    @PostMapping("getmsg")
    @ApiOperation(value = "获取公告")
    public Result<List<MsgInfoVo>> get(@RequestBody @ApiParam("前端传递的 sessionId ，json格式") CommonQO qo) {
        try {
            HttpSession session = RoneSessionContext.getInstance().getSession(qo.getSessionId());
            LogonUserInfo logonUserInfo = (LogonUserInfo) session.getAttribute(HttpSessionAttributeConstant.LOGON_USER_INFO);
            if (logonUserInfo == null) {
                return Result.success(new ArrayList<>());
            }
            ArrayList<MsgInfoVo> msgInfoVos = new ArrayList<>();
            MsgInfoVo vo = new MsgInfoVo();
            vo.setMsgText(sysParamService.getSysParamValue(SystemParamKeyEnum.ANNOUNCEMENT));
            msgInfoVos.add(vo);
            return Result.success(msgInfoVos);
        } catch (RoneException e) {
            return Result.success(new ArrayList<>());
        }
    }

}
