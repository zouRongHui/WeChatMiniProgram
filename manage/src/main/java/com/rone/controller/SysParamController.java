package com.rone.controller;

import com.github.pagehelper.PageInfo;
import com.rone.entity.SysParam;
import com.rone.service.SysParamService;
import com.rone.utils.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import java.util.Date;

/**
 * 系统参数管理
 *
 * @author rone
 */
@Controller
@RequestMapping("sysparam")
public class SysParamController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysParamController.class);

    @Autowired
    private SysParamService sysParamService;

    /**
     * 分页查询
     *
     * @param model
     * @param page      页码
     * @param size      每页展示条数
     * @param paramKey  参数key
     * @param paramName 参数名称
     * @return
     */
    @GetMapping("list")
    public String list(Model model, Integer page, Integer size, String paramKey, String paramName) {
        if ((page == null || page == 0) || (size == null || size == 0)) {
            page = 1;
            size = 10;
        }
        PageInfo<SysParam> pageInfo = sysParamService.getPageList(page, size, paramKey, paramName);
        model.addAttribute("sysParamList", pageInfo.getList());
        // 解决freemarker自动对数值类型数据采用千分位分割
        model.addAttribute("page", String.valueOf(pageInfo.getPageNum()));
        model.addAttribute("size", String.valueOf(pageInfo.getPageSize()));
        model.addAttribute("total", String.valueOf(pageInfo.getTotal()));
        model.addAttribute("paramKey", paramKey == null ? "" : paramKey);
        model.addAttribute("paramName", paramName == null ? "" : paramName);
        return "sysparam/sysparam-list";
    }

    /**
     * 新增
     *
     * @return
     */
    @GetMapping("add")
    public String add() {
        return "sysparam/sysparam-add";
    }

    /**
     * 新增操作
     *
     * @param sysParam 参数信息
     * @return
     */
    @PostMapping("add")
    @ResponseBody
    public JsonResult addPost(SysParam sysParam) {
        JsonResult result = new JsonResult();
        sysParam.setStatus("0");
        sysParam.setDeleted("0");
        sysParam.setCreateTime(new Date());
        // 项目为防止XSS攻击将html的标签做了编码转换，但系统参数中的数据需要保存非转义的字符
        sysParam.setParamValue(HtmlUtils.htmlUnescape(sysParam.getParamValue()));
        sysParamService.add(sysParam);
        result.setSuccess(true);
        result.setMsg("新增成功！");
        return result;
    }

    /**
     * 更新
     *
     * @param model
     * @param id    ID
     * @return
     */
    @GetMapping("edit")
    public String edit(Model model, Integer id) {
        SysParam sysParam = sysParamService.getById(id);
        model.addAttribute("sysParam", sysParam);
        return "sysparam/sysparam-edit";
    }

    /**
     * 更新操作
     *
     * @param sysParam 参数信息
     * @return
     */
    @PostMapping("edit")
    @ResponseBody
    public JsonResult editPost(SysParam sysParam) {
        // 项目为防止XSS攻击将html的标签做了编码转换，但系统参数中的数据需要保存非转义的字符
        sysParam.setParamValue(HtmlUtils.htmlUnescape(sysParam.getParamValue()));
        sysParamService.update(sysParam);
        JsonResult result = new JsonResult();
        result.setSuccess(true);
        result.setMsg("更新成功！");
        return result;
    }

    /**
     * 停用
     *
     * @param id ID
     * @return
     */
    @PostMapping("stop")
    @ResponseBody
    public JsonResult stop(Integer id) {
        sysParamService.stop(id);
        JsonResult result = new JsonResult();
        result.setSuccess(true);
        result.setMsg("已停用！");
        return result;
    }

    /**
     * 启用
     *
     * @param id ID
     * @return
     */
    @PostMapping("start")
    @ResponseBody
    public JsonResult start(Integer id) {
        sysParamService.start(id);
        JsonResult result = new JsonResult();
        result.setSuccess(true);
        result.setMsg("已启用！");
        return result;
    }

    /**
     * 删除
     *
     * @param ids ID
     * @return
     */
    @PostMapping("delete")
    @ResponseBody
    public JsonResult delete(Integer... ids) {
        sysParamService.delete(ids);
        JsonResult result = new JsonResult();
        result.setMsg("已删除！");
        result.setSuccess(true);
        return result;
    }

}
