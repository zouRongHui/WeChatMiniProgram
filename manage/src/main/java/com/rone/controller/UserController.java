package com.rone.controller;

import com.github.pagehelper.PageInfo;
import com.rone.entity.RoleInfo;
import com.rone.entity.AdminUserInfo;
import com.rone.enumeration.UserInfoStatusEnum;
import com.rone.service.IRoleInfoService;
import com.rone.service.AdminUserInfoService;
import com.rone.utils.JsonResult;
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
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 用户管理
 *
 * @author rone
 */
@Controller
@RequestMapping("user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private AdminUserInfoService adminUserInfoService;
    @Autowired
    private IRoleInfoService roleInfoService;

    /**
     * 用户列表
     *
     * @param model
     * @param page     页码
     * @param size     每页展示条数
     * @param userName 用户名称
     * @return
     */
    @GetMapping("list")
    public String list(Model model, Integer page, Integer size, String userName) {
        if ((page == null || page == 0) || (size == null || size == 0)) {
            page = 1;
            size = 15;
        }
        PageInfo<AdminUserInfo> pageInfo = adminUserInfoService.getPageList(page, size, userName);
        model.addAttribute("userInfoList", pageInfo.getList());
        // 解决freemarker自动对数值类型数据采用千分位分割
        model.addAttribute("page", String.valueOf(pageInfo.getPageNum()));
        model.addAttribute("size", String.valueOf(pageInfo.getPageSize()));
        model.addAttribute("total", String.valueOf(pageInfo.getTotal()));
        return "user/user-list";
    }

    /**
     * 新增
     *
     * @param model
     * @return
     */
    @GetMapping("add")
    public String add(Model model, HttpServletRequest request) {
        List<RoleInfo> roleInfoList = roleInfoService.findAll();
        model.addAttribute("roleInfoList", roleInfoList);
        String token = String.valueOf(System.currentTimeMillis());
        model.addAttribute("token", token);
        request.getSession().setAttribute("add_user_token", token);
        return "user/user-add";
    }

    /**
     * 新增操作
     *
     * @param adminUserInfo 用户信息
     * @return
     */
    @PostMapping("add")
    @ResponseBody
    public JsonResult addPost(AdminUserInfo adminUserInfo, String token, HttpServletRequest request) {
        JsonResult result = new JsonResult();
        String realToken = (String) request.getSession().getAttribute("add_user_token");
        if (StringUtils.isEmpty(realToken) || !realToken.equals(token)) {
            result.setSuccess(false);
            result.setMsg("该请求非法！");
            return result;
        }

        AdminUserInfo info = adminUserInfoService.getByAccount(adminUserInfo.getAccount());
        if (info != null) {
            result.setSuccess(false);
            result.setMsg("该账号已存在！");
            return result;
        }
        // 将密码加密后存入数据库
        adminUserInfo.setPassword(TripleDESUtil.encryptMode(adminUserInfo.getPassword()));
        adminUserInfo.setStarted("0");
        adminUserInfo.setCreateTime(new Date());
        adminUserInfoService.add(adminUserInfo);
        result.setSuccess(true);
        result.setMsg("新增成功！");
        request.getSession().removeAttribute("add_user_token");
        return result;
    }

    /**
     * 更新
     *
     * @param model
     * @param id    用户ID
     * @return
     */
    @GetMapping("edit")
    public String edit(Model model, Integer id) {
        List<RoleInfo> roleInfoList = roleInfoService.findAll();
        model.addAttribute("roleInfoList", roleInfoList);
        AdminUserInfo adminUserInfo = adminUserInfoService.getById(id);
        model.addAttribute("userInfo", adminUserInfo);
        return "user/user-edit";
    }

    /**
     * 更新操作
     *
     * @param adminUserInfo 用户信息
     * @return
     */
    @PostMapping("edit")
    @ResponseBody
    public JsonResult editPost(AdminUserInfo adminUserInfo) {
        JsonResult result = new JsonResult();
        adminUserInfo.setStatus(UserInfoStatusEnum.NORMAL.getCode());
        adminUserInfo.setTempLockInvalidTime(null);
        adminUserInfoService.update(adminUserInfo);
        result.setSuccess(true);
        result.setMsg("更新成功！");
        return result;
    }

    /**
     * 密码重置
     *
     * @param id 用户ID
     * @return
     */
    @PostMapping("passwordrefresh")
    @ResponseBody
    public JsonResult passwordRefresh(Integer id) {
        JsonResult result = new JsonResult();
        String newPassword = UUID.randomUUID().toString().substring(0, 8);
        AdminUserInfo adminUserInfo = new AdminUserInfo();
        adminUserInfo.setId(id);
        // 将新密码加密后存入数据库
        adminUserInfo.setPassword(TripleDESUtil.encryptMode(newPassword));
        adminUserInfo.setStatus(UserInfoStatusEnum.NORMAL.getCode());
        adminUserInfo.setTempLockInvalidTime(null);
        adminUserInfoService.update(adminUserInfo);
        result.setSuccess(true);
        result.setMsg("重置成功，新密码 " + newPassword);
        return result;
    }

    @GetMapping("editpassword")
    public String editPassword(Model model, Integer id) {
        model.addAttribute("id", id);
        return "user/user-edit-password";
    }

    @PostMapping("editpassword")
    @ResponseBody
    public JsonResult editPassword(HttpServletRequest request, Integer id, String oldPassword, String newPassword) {
        JsonResult result = new JsonResult();
        AdminUserInfo adminUserInfo = adminUserInfoService.getById(id);
        // 将密码加密后校验
        if (!adminUserInfo.getPassword().equals(TripleDESUtil.encryptMode(oldPassword))) {
            result.setSuccess(false);
            result.setMsg("密码错误，请重试！");
            return result;
        }
        // 将新密码加密后存入数据库
        adminUserInfo.setPassword(TripleDESUtil.encryptMode(newPassword));
        AdminUserInfo info = adminUserInfoService.update(adminUserInfo);
        // 替换session中用户信息
        HttpSession session = request.getSession();
        session.removeAttribute("userInfo");
        session.setAttribute("userInfo", info);
        result.setSuccess(true);
        result.setMsg("修改成功");
        return result;
    }

    /**
     * 停用
     *
     * @param request 请求体
     * @param id      用户ID
     * @return
     */
    @PostMapping("stop")
    @ResponseBody
    public JsonResult stop(HttpServletRequest request, Integer id) {
        JsonResult result = new JsonResult();
        HttpSession session = request.getSession();
        AdminUserInfo adminUserInfo = (AdminUserInfo) session.getAttribute("userInfo");
        AdminUserInfo byId = adminUserInfoService.getById(id);
        if (adminUserInfo.getAccount().equals(byId.getAccount())) {
            result.setSuccess(false);
            result.setMsg("不可停用正在操作的用户！");
            return result;
        }
        adminUserInfoService.stop(id);
        result.setSuccess(true);
        result.setMsg("已停用！");
        return result;
    }

    /**
     * 启用
     *
     * @param id 用户ID
     * @return
     */
    @PostMapping("start")
    @ResponseBody
    public JsonResult start(Integer id) {
        JsonResult result = new JsonResult();
        adminUserInfoService.start(id);
        result.setSuccess(true);
        result.setMsg("已启用！");
        return result;
    }

    /**
     * 删除
     *
     * @param ids 用户ID
     * @return
     */
    @PostMapping("delete")
    @ResponseBody
    public JsonResult delete(Integer... ids) {
        JsonResult result = new JsonResult();
        for (Integer id : ids) {
            AdminUserInfo adminUserInfo = adminUserInfoService.getById(id);
            if ("1".equals(adminUserInfo.getStarted())) {
                result.setSuccess(false);
                result.setMsg("请先停用该用户！");
                return result;
            }
        }
        adminUserInfoService.delete(ids);
        result.setSuccess(true);
        result.setMsg("已删除！");
        return result;
    }

}
