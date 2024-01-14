package com.rone.controller;

import com.rone.entity.AdminLoginLog;
import com.rone.entity.MenuInfo;
import com.rone.entity.AdminUserInfo;
import com.rone.enumeration.AdminLoginLogStatusEnum;
import com.rone.enumeration.SystemParamKeyEnum;
import com.rone.enumeration.UserInfoStatusEnum;
import com.rone.service.MenuInfoService;
import com.rone.service.SysParamService;
import com.rone.service.AdminUserInfoService;
import com.rone.utils.JsonResult;
import com.rone.utils.date.DateUtil;
import com.rone.utils.security.TripleDESUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 权限控制
 *
 * @author rone
 */
@Controller
@RequestMapping("auth")
public class AuthController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private AdminUserInfoService adminUserInfoService;
    @Autowired
    private MenuInfoService menuInfoService;
    @Autowired
    private SysParamService sysParamService;

    /**
     * 登录页面
     *
     * @return
     */
    @GetMapping("login")
    public String login() {
        return "login";
    }

    /**
     * 登录操作
     *
     * @param request  请求体
     * @param account  账户密文
     * @param password 密码密文
     * @return
     */
    @PostMapping("login")
    @ResponseBody
    public JsonResult loginPost(HttpServletRequest request, String account, String password) {
        JsonResult result = new JsonResult();
        result.setSuccess(false);
        if (StringUtils.isBlank(account) || StringUtils.isBlank(password)) {
            return result;
        }

        AdminUserInfo adminUserInfo = adminUserInfoService.getByAccount(account);
        Calendar now = Calendar.getInstance();
        // 为避免 用户名遍历漏洞 ，无效的账号也走防 密码暴力破解漏洞 机制
        if (adminUserInfo != null) {
            if (UserInfoStatusEnum.TEMP_LOCK.getCode().equals(adminUserInfo.getStatus())) {
                if (adminUserInfo.getTempLockInvalidTime().getTime() > now.getTime().getTime()) {
                    result.setMsg(String.format("用户名或密码错误次数过多，请于 %s 之后再试！", DateUtil.getDateStr(adminUserInfo.getTempLockInvalidTime(), "yyyy-MM-dd HH:mm")));
                    return result;
                } else {
                    adminUserInfo.setStatus(UserInfoStatusEnum.NORMAL.getCode());
                    adminUserInfo.setTempLockInvalidTime(null);
                    adminUserInfoService.update(adminUserInfo);
                }
            }

            int times = 0;
            try {
                times = Integer.parseInt(sysParamService.getSysParamValue(SystemParamKeyEnum.ADMIN_LOGIN_FAIL_TIMES_LIMIT_TIMES.getCode()));
            } catch (NumberFormatException e) {
                LOGGER.warn("用户登陆失败次数限制，获取 admin_login_fail_times_limit_times 参数错误已采用默认值 {}，出错信息：{}", SystemParamKeyEnum.ADMIN_LOGIN_FAIL_TIMES_LIMIT_TIMES.getDefaultValue(), e);
            }
            if (times <= 0) {
                times = Integer.parseInt(SystemParamKeyEnum.ADMIN_LOGIN_FAIL_TIMES_LIMIT_TIMES.getDefaultValue());
            }
            HttpSession session = request.getSession();
            AdminLoginLog adminLoginLog = new AdminLoginLog();
            adminLoginLog.setLoginAccount(account);
            adminLoginLog.setSessionId(session.getId());
            adminLoginLog.setLoginTime(new Date());
            // 增加了代理服务器之后获取用户ip
            String logonIp = request.getHeader("x-forwarded-for");
            if (StringUtils.isEmpty(logonIp) || "unknown".equalsIgnoreCase(logonIp)) {
                logonIp = request.getHeader("Proxy-Client-IP");
            }
            if (StringUtils.isEmpty(logonIp) || "unknown".equalsIgnoreCase(logonIp)) {
                logonIp = request.getHeader("WL-Proxy-Client-IP");
            }
            if (StringUtils.isEmpty(logonIp) || "unknown".equalsIgnoreCase(logonIp)) {
                logonIp = request.getRemoteAddr();
            }
            adminLoginLog.setLoginIp(logonIp);
            // 将密码加密后校验
            if (!adminUserInfo.getPassword().equals(TripleDESUtil.encryptMode(password))) {
                adminLoginLog.setLoginStatus(AdminLoginLogStatusEnum.PASS_FAIL.getCode());
                adminLoginLog.setLoginFailMessage(AdminLoginLogStatusEnum.PASS_FAIL.getName());
                adminUserInfoService.insertLoginLog(adminLoginLog);

                int minutes = 0;
                try {
                    minutes = Integer.parseInt(sysParamService.getSysParamValue(SystemParamKeyEnum.ADMIN_LOGIN_FAIL_TIMES_LIMIT_MINUTES.getCode()));
                } catch (NumberFormatException e) {
                    LOGGER.warn("用户登陆失败次数限制，获取 admin_login_fail_times_limit_minutes 参数错误已采用默认值 {}，出错信息：{}", SystemParamKeyEnum.ADMIN_LOGIN_FAIL_TIMES_LIMIT_MINUTES.getDefaultValue(), e);
                }
                if (minutes <= 0) {
                    minutes = Integer.parseInt(SystemParamKeyEnum.ADMIN_LOGIN_FAIL_TIMES_LIMIT_MINUTES.getDefaultValue());
                }
                int disableTime = 0;
                try {
                    disableTime = Integer.parseInt(sysParamService.getSysParamValue(SystemParamKeyEnum.ADMIN_LOGIN_FAIL_TIMES_DISABLE_TIME.getCode()));
                } catch (NumberFormatException e) {
                    LOGGER.warn("用户登陆失败次数限制，获取 admin_login_fail_times_disable_time 参数错误已采用默认值 {}，出错信息：{}", SystemParamKeyEnum.ADMIN_LOGIN_FAIL_TIMES_DISABLE_TIME.getDefaultValue(), e);
                }
                if (disableTime <= 0) {
                    disableTime = Integer.parseInt(SystemParamKeyEnum.ADMIN_LOGIN_FAIL_TIMES_DISABLE_TIME.getDefaultValue());
                }
                Calendar time = Calendar.getInstance();
                time.add(Calendar.MINUTE, -minutes);
                List<AdminLoginLog> adminLoginLogList = adminUserInfoService.getFailLoginLogInTime(account, time.getTime());
                if (adminLoginLogList.size() >= times) {
                    time.setTime(adminLoginLogList.get(0).getLoginTime());
                    time.add(Calendar.HOUR_OF_DAY, disableTime);
                    time.add(Calendar.MINUTE, 1);
                    adminUserInfo.setStatus(UserInfoStatusEnum.TEMP_LOCK.getCode());
                    adminUserInfo.setTempLockInvalidTime(time.getTime());
                    adminUserInfoService.update(adminUserInfo);
                    result.setMsg(String.format("用户名或密码错误次数过多，请于 %s 之后再试！", DateUtil.getDateStr(time.getTime(), "yyyy-MM-dd HH:mm")));
                } else {
                    result.setMsg(String.format("用户名或密码错误，再出错 %d 次数后将临时锁定，为不影响您是使用请谨慎操作！", times - adminLoginLogList.size()));
                }
                return result;
            }
            // 加载权限
            adminUserInfo.setPermissionCodeSet(menuInfoService.getPermissionCodeByRole(adminUserInfo.getRoleId()));
            session.setAttribute("userInfo", adminUserInfo);
            result.setSuccess(true);
            result.setMsg("登陆成功！");
            adminLoginLog.setLoginStatus(AdminLoginLogStatusEnum.SUCCESS.getCode());
            adminLoginLog.setLoginFailMessage(AdminLoginLogStatusEnum.SUCCESS.getName());
            adminUserInfoService.insertLoginLog(adminLoginLog);
            return result;
        } else {
            int times = 0;
            try {
                times = Integer.parseInt(sysParamService.getSysParamValue(SystemParamKeyEnum.ADMIN_LOGIN_FAIL_TIMES_LIMIT_TIMES.getCode()));
            } catch (NumberFormatException e) {
                LOGGER.warn("用户登陆失败次数限制，获取 admin_login_fail_times_limit_times 参数错误已采用默认值 {}，出错信息：{}", SystemParamKeyEnum.ADMIN_LOGIN_FAIL_TIMES_LIMIT_TIMES.getDefaultValue(), e);
            }
            if (times <= 0) {
                times = Integer.parseInt(SystemParamKeyEnum.ADMIN_LOGIN_FAIL_TIMES_LIMIT_TIMES.getDefaultValue());
            }
            int minutes = 0;
            try {
                minutes = Integer.parseInt(sysParamService.getSysParamValue(SystemParamKeyEnum.ADMIN_LOGIN_FAIL_TIMES_LIMIT_MINUTES.getCode()));
            } catch (NumberFormatException e) {
                LOGGER.warn("用户登陆失败次数限制，获取 admin_login_fail_times_limit_minutes 参数错误已采用默认值 {}，出错信息：{}", SystemParamKeyEnum.ADMIN_LOGIN_FAIL_TIMES_LIMIT_MINUTES.getDefaultValue(), e);
            }
            if (minutes <= 0) {
                minutes = Integer.parseInt(SystemParamKeyEnum.ADMIN_LOGIN_FAIL_TIMES_LIMIT_MINUTES.getDefaultValue());
            }
            HttpSession session = request.getSession();
            AdminLoginLog adminLoginLog = new AdminLoginLog();
            adminLoginLog.setLoginAccount(account);
            adminLoginLog.setSessionId(session.getId());
            adminLoginLog.setLoginTime(new Date());
            // 增加了代理服务器之后获取用户ip
            String logonIp = request.getHeader("x-forwarded-for");
            if (StringUtils.isEmpty(logonIp) || "unknown".equalsIgnoreCase(logonIp)) {
                logonIp = request.getHeader("Proxy-Client-IP");
            }
            if (StringUtils.isEmpty(logonIp) || "unknown".equalsIgnoreCase(logonIp)) {
                logonIp = request.getHeader("WL-Proxy-Client-IP");
            }
            if (StringUtils.isEmpty(logonIp) || "unknown".equalsIgnoreCase(logonIp)) {
                logonIp = request.getRemoteAddr();
            }
            adminLoginLog.setLoginIp(logonIp);
            adminLoginLog.setLoginStatus(AdminLoginLogStatusEnum.NO_ACCOUNT.getCode());
            adminLoginLog.setLoginFailMessage(AdminLoginLogStatusEnum.NO_ACCOUNT.getName());
            adminUserInfoService.insertLoginLog(adminLoginLog);

            Calendar time = Calendar.getInstance();
            time.add(Calendar.MINUTE, -minutes);
            List<AdminLoginLog> adminLoginLogList = adminUserInfoService.getFailLoginLogInTime(account, time.getTime());
            if (adminLoginLogList.size() >= times) {
                time.setTime(adminLoginLogList.get(0).getLoginTime());
                time.add(Calendar.MINUTE, minutes);
                time.add(Calendar.MINUTE, 1);
                result.setMsg(String.format("用户名或密码错误次数过多，请于 %s 之后再试！", DateUtil.getDateStr(time.getTime(), "yyyy-MM-dd HH:mm")));
            } else {
                if (times - adminLoginLogList.size() > 0) {
                    result.setMsg(String.format("用户名或密码错误，再出错 %d 次数后将临时锁定，为不影响您是使用请谨慎操作！", times - adminLoginLogList.size()));
                } else {
                    time.setTime(adminLoginLogList.get(0).getLoginTime());
                    time.add(Calendar.MINUTE, minutes);
                    time.add(Calendar.MINUTE, 1);
                    result.setMsg(String.format("用户名或密码错误次数过多，请于 %s 之后再试！", DateUtil.getDateStr(time.getTime(), "yyyy-MM-dd HH:mm")));
                }
            }

            return result;
        }
    }

    /**
     * 首页
     *
     * @param request 请求体
     * @param model
     * @return
     */
    @GetMapping("index")
    public String index(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        AdminUserInfo adminUserInfo = (AdminUserInfo) session.getAttribute("userInfo");
        List<MenuInfo> treeMenu = null;
        // 超级用户(无任何角色)使用所有权限
        if (adminUserInfo.getRoleId() == null) {
            treeMenu = menuInfoService.getRootTreeMenu();
        } else {
            // 其他用户根据角色获取不同权限
            treeMenu = menuInfoService.getRoleTreeMenu(adminUserInfo.getRoleId());
        }
        model.addAttribute("treeMenu", treeMenu);
        model.addAttribute("userInfo", adminUserInfo);
        return "index";
    }

    /**
     * 欢迎页面
     *
     * @return
     */
    @GetMapping("welcome")
    public String welcome(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        AdminUserInfo adminUserInfo = (AdminUserInfo) session.getAttribute("userInfo");
        model.addAttribute("userInfo", adminUserInfo);
        return "welcome";
    }

    /**
     * 退出登录
     *
     * @param request 请求体
     * @return
     */
    @GetMapping("logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("userInfo");
        return "login";
    }
}
