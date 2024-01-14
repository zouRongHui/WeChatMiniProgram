package com.rone.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.rone.entity.MenuInfo;
import com.rone.entity.MenuTreeInfo;
import com.rone.entity.RoleInfo;
import com.rone.entity.AdminUserInfo;
import com.rone.service.MenuInfoService;
import com.rone.service.IRoleInfoService;
import com.rone.service.AdminUserInfoService;
import com.rone.utils.JsonResult;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 角色管理
 *
 * @author rone
 */
@Controller
@RequestMapping("role")
public class RoleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private IRoleInfoService roleInfoService;
    @Autowired
    private MenuInfoService menuInfoService;
    @Autowired
    private AdminUserInfoService adminUserInfoService;

    /**
     * 角色列表
     *
     * @param model
     * @param page     页码
     * @param size     每页展示条数
     * @param roleName 角色名称
     * @return
     */
    @GetMapping("list")
    public String list(Model model, Integer page, Integer size, String roleName) {
        if ((page == null || page == 0) || (size == null || size == 0)) {
            page = 1;
            size = 15;
        }
        PageInfo<RoleInfo> pageInfo = roleInfoService.getPageList(page, size, roleName);
        model.addAttribute("roleInfoList", pageInfo.getList());
        // 解决freemarker自动对数值类型数据采用千分位分割
        model.addAttribute("page", String.valueOf(pageInfo.getPageNum()));
        model.addAttribute("size", String.valueOf(pageInfo.getPageSize()));
        model.addAttribute("total", String.valueOf(pageInfo.getTotal()));
        return "role/role-list";
    }

    /**
     * 新增
     *
     * @param model
     * @return
     */
    @GetMapping("add")
    public String add(Model model) {
        List<MenuTreeInfo> treeData = menuInfoService.getTree();
        model.addAttribute("treeData", JSON.toJSONString(treeData));
        return "role/role-add";
    }


    /**
     * 新增操作
     *
     * @param paramMap 参数map
     * @return
     */
    @PostMapping("add")
    @ResponseBody
    public JsonResult addPost(@RequestBody Map<String, Object> paramMap) {
        JsonResult result = new JsonResult();
        // 角色名称
        String roleName = paramMap.get("roleName").toString();
        String roleDesc = paramMap.get("roleDesc").toString();
        // 菜单id
        List<Integer> menuIdList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
            if ("roleName".equals(entry.getKey()) || "roleDesc".equals(entry.getKey())) {
                continue;
            }
            menuIdList.add(Integer.parseInt(entry.getValue().toString()));
        }
        RoleInfo roleInfo = new RoleInfo();
        roleInfo.setRoleName(roleName);
        roleInfo.setRoleDesc(roleDesc);
        roleInfoService.add(roleInfo, menuIdList);
        result.setSuccess(true);
        result.setMsg("新增成功！");
        return result;
    }

    /**
     * 更新
     *
     * @param model
     * @param id    角色ID
     * @return
     */
    @GetMapping("edit")
    public String edit(Model model, Integer id) {
        List<MenuTreeInfo> treeData = menuInfoService.getTree();
        model.addAttribute("treeData", JSON.toJSONString(treeData));
        model.addAttribute("roleInfo", roleInfoService.geyById(id));
        List<Integer> menuIds = roleInfoService.selectMenuIdListByRoleId(id);
        List<Integer> menuIdList = new ArrayList<>();
        for (Integer menuId : menuIds) {
            MenuInfo menuInfo = menuInfoService.getById(menuId);
            if (menuInfo != null && StringUtils.isNotBlank(menuInfo.getUrl())) {
                menuIdList.add(menuId);
            }
        }
        model.addAttribute("menuIdList", menuIdList);
        return "role/role-edit";
    }

    /**
     * 更新操作
     *
     * @param paramMap 参数map
     * @return
     */
    @PostMapping("edit")
    @ResponseBody
    public JsonResult editPost(@RequestBody Map<String, Object> paramMap) {
        JsonResult result = new JsonResult();
        // 角色名称
        String roleName = paramMap.get("roleName").toString();
        String roleDesc = paramMap.get("roleDesc").toString();
        String roleId = paramMap.get("id").toString();
        // 菜单id
        List<Integer> menuIdList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
            if ("roleName".equals(entry.getKey()) || "roleDesc".equals(entry.getKey()) || "id".equals(entry.getKey())) {
                continue;
            }
            menuIdList.add(Integer.parseInt(entry.getValue().toString()));
        }
        RoleInfo roleInfo = new RoleInfo();
        roleInfo.setId(Integer.parseInt(roleId));
        roleInfo.setRoleName(roleName);
        roleInfo.setRoleDesc(roleDesc);
        roleInfoService.update(roleInfo, menuIdList);
        result.setSuccess(true);
        result.setMsg("更新成功！");
        return result;
    }

    /**
     * 删除操作
     *
     * @param ids 角色ID
     * @return
     */
    @PostMapping("delete")
    @ResponseBody
    public JsonResult delete(Integer... ids) {
        JsonResult result = new JsonResult();
        for (Integer id : ids) {
            List<AdminUserInfo> adminUserInfos = adminUserInfoService.getByRoleId(id);
            if (adminUserInfos != null && !adminUserInfos.isEmpty()) {
                result.setSuccess(false);
                result.setMsg("角色已绑定用户，请解绑后操作！");
                return result;
            }
        }
        roleInfoService.delete(ids);
        result.setSuccess(true);
        result.setMsg("已删除！");
        return result;
    }

}
