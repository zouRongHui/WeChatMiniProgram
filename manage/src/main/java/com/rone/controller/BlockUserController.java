package com.rone.controller;

import com.github.pagehelper.PageInfo;
import com.rone.entity.BlockUser;
import com.rone.entity.AdminUserInfo;
import com.rone.qo.BlockUserQO;
import com.rone.service.BlockUserService;
import com.rone.utils.JsonResult;
import com.rone.vo.BlockUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 黑名单用户管理
 *
 * @author rone
 */
@Controller
@RequestMapping("blockUser")
public class BlockUserController {

    @Autowired
    private BlockUserService service;

    /**
     * 分页查询
     *
     * @param model
     * @param qo
     * @return
     */
    @GetMapping("/list")
    public String list(Model model, BlockUserQO qo) {
        PageInfo<BlockUserVO> pageInfo = service.getPageList(qo);
        model.addAttribute("qo", qo);
        model.addAttribute("datas", pageInfo.getList());
        model.addAttribute("page", pageInfo.getPageNum());
        model.addAttribute("size", pageInfo.getPageSize());
        model.addAttribute("total", pageInfo.getTotal());

        return "blockUser/blockUser-list";
    }

    /**
     * 跳转到新增页面
     *
     * @return url 跳转地址
     */
    @GetMapping("/addView")
    public String addView() {
        return "blockUser/blockUser-add";
    }

    /**
     * 新增黑名单用户
     *
     * @param request
     * @param blockUser
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public JsonResult add(HttpServletRequest request, BlockUser blockUser) {
        try {
            AdminUserInfo adminUserInfo = (AdminUserInfo) request.getSession().getAttribute("userInfo");
            blockUser.setCreator(adminUserInfo.getAccount());
            service.add(blockUser);
            return JsonResult.success("新增成功！");
        } catch (Exception e) {
            return JsonResult.failure("新增失败，失败原因：" + e.getMessage());
        }
    }

    /**
     * 删除
     *
     * @param ids ID
     * @return
     */
    @PostMapping("/delete")
    @ResponseBody
    public JsonResult delete(Long... ids) {
        service.delete(ids);
        return JsonResult.success("已删除！");
    }

    /**
     * 启用
     *
     * @param id ID
     * @return
     */
    @PostMapping("/usable")
    @ResponseBody
    public JsonResult usable(Long id) {
        service.usable(id);
        return JsonResult.success("已启用！");
    }

    /**
     * 停用
     *
     * @param id ID
     * @return
     */
    @PostMapping("/disable")
    @ResponseBody
    public JsonResult disable(Long id) {
        service.disable(id);
        return JsonResult.success("已停用！");
    }
}
