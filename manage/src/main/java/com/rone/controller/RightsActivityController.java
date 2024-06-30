package com.rone.controller;

import com.github.pagehelper.PageInfo;
import com.rone.entity.RightsActivity;
import com.rone.entity.RightsActivityAllowList;
import com.rone.enumeration.RightsActivityPhaseRightsNumCycleEnum;
import com.rone.enumeration.RightsActivityReceiveTimesSingleFrequencyEnum;
import com.rone.enumeration.YesOrNoEnum;
import com.rone.exception.ParamException;
import com.rone.exception.RoneException;
import com.rone.qo.RightsActivityQO;
import com.rone.service.RightsActivityService;
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
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * 权益活动配置
 *
 * @author rone
 */
@Controller
@RequestMapping("/rightsActivity")
public class RightsActivityController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RightsActivityController.class);

    @Autowired
    private RightsActivityService service;

    /**
     * 分页查询
     *
     * @param model
     * @param qo
     * @return
     */
    @GetMapping("/list")
    public String list(Model model, RightsActivityQO qo) {
        PageInfo<RightsActivity> pageInfo = service.pageList(qo);
        model.addAttribute("qo", qo);
        model.addAttribute("datas", pageInfo.getList());
        // 解决freemarker自动对数值类型数据采用千分位分割
        model.addAttribute("page", String.valueOf(pageInfo.getPageNum()));
        model.addAttribute("size", String.valueOf(pageInfo.getPageSize()));
        model.addAttribute("total", String.valueOf(pageInfo.getTotal()));

        return "rightsActivity/rightsActivity-list";
    }

    /**
     * 新增
     *
     * @param model
     * @return
     */
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("receiveTimesSingleFrequencys", RightsActivityReceiveTimesSingleFrequencyEnum.values());
        model.addAttribute("phaseRightsNumCycles", RightsActivityPhaseRightsNumCycleEnum.values());
        model.addAttribute("hasAllowLists", YesOrNoEnum.values());
        return "rightsActivity/rightsActivity-add";
    }

    /**
     * 新增操作
     *
     * @param rightsActivity
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public JsonResult addPost(RightsActivity rightsActivity) {
        service.add(rightsActivity);
        return JsonResult.success("新增成功！");
    }

    /**
     * 更新
     *
     * @param model
     * @param id    ID
     * @return
     */
    @GetMapping("/edit")
    public String edit(Model model, Integer id) {
        RightsActivity rightsActivity = service.findById(id);
        model.addAttribute("data", rightsActivity);
        model.addAttribute("receiveTimesSingleFrequencys", RightsActivityReceiveTimesSingleFrequencyEnum.values());
        model.addAttribute("phaseRightsNumCycles", RightsActivityPhaseRightsNumCycleEnum.values());
        model.addAttribute("hasAllowLists", YesOrNoEnum.values());
        return "rightsActivity/rightsActivity-edit";
    }

    /**
     * 更新操作
     *
     * @param rightsActivity
     * @return
     */
    @PostMapping("/edit")
    @ResponseBody
    public JsonResult editPost(RightsActivity rightsActivity) {
        try {
            service.edit(rightsActivity);
            return JsonResult.success("更新成功！");
        } catch (RoneException e) {
            return JsonResult.failure(e.getMessage());
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
    public JsonResult delete(Integer... ids) {
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
    public JsonResult usable(Integer id) {
        try {
            service.usable(id);
            return JsonResult.success("已启用！");
        } catch (RoneException e) {
            return JsonResult.failure(e.getMessage());
        }
    }

    /**
     * 停用
     *
     * @param id ID
     * @return
     */
    @PostMapping("/disable")
    @ResponseBody
    public JsonResult disable(Integer id) {
        try {
            service.disable(id);
            return JsonResult.success("已停用！");
        } catch (RoneException e) {
            return JsonResult.failure(e.getMessage());
        }
    }

    /**
     * 查看小程序码
     *
     * @param model
     * @param id    ID
     * @return
     */
    @GetMapping("/miniAppCode")
    public String miniAppCode(Model model, Integer id) throws RoneException, IOException, URISyntaxException {
        model.addAttribute("miniAppCodeUrl", service.getRightsActivityMiniAppCode(id));
        return "rightsActivity/rightsActivity-miniAppCode";
    }

    /**
     * 白名单 - 查询
     *
     * @return
     */
    @GetMapping("/allowListView")
    public String allowListView(Model model, Integer pageNum, Integer pageSize, Integer id, String phone) {
        PageInfo<RightsActivityAllowList> pageInfo = service.allowListPageList(pageNum, pageSize, id, phone);
        model.addAttribute("id", id);
        model.addAttribute("phone", phone);
        model.addAttribute("datas", pageInfo.getList());
        model.addAttribute("page", pageInfo.getPageNum());
        model.addAttribute("size", pageInfo.getPageSize());
        model.addAttribute("total", pageInfo.getTotal());

        model.addAttribute("data", service.findById(id));

        return "rightsActivity/rightsActivity-allowList";
    }

    /**
     * 白名单新增 - 页面
     *
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/allowListAddView")
    public String allowListAddView(Model model, Integer id) {
        model.addAttribute("id", id);
        return "rightsActivity/rightsActivity-allowList-add";
    }

    /**
     * 白名单新增
     *
     * @param rightsActivityAllowList
     * @return
     * @throws RoneException
     */
    @PostMapping("/allowListAdd")
    @ResponseBody
    public JsonResult allowListAdd(RightsActivityAllowList rightsActivityAllowList) throws RoneException {
        service.allowListAdd(rightsActivityAllowList);
        return JsonResult.success("新增成功！");
    }

    /**
     * 白名单删除
     *
     * @param phones
     * @param rightsActivityId
     * @return
     * @throws RoneException
     */
    @PostMapping("/allowListDelete")
    @ResponseBody
    public JsonResult allowListDelete(String[] phones, Integer rightsActivityId) throws RoneException {
        service.allowListDelete(phones, rightsActivityId);
        return JsonResult.success("已删除！");
    }

    /**
     * 白名单删除 - 全部删除
     *
     * @param rightsActivityId
     * @return
     * @throws RoneException
     */
    @PostMapping("/allowListDeleteAll")
    @ResponseBody
    public JsonResult allowListDeleteAll(Integer rightsActivityId) throws RoneException {
        service.allowListDeleteAll(rightsActivityId);
        return JsonResult.success("已全部删除！");
    }

    /**
     * 白名单导入 - 页面
     *
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/allowListImportView")
    public String allowListImportView(Model model, Integer id) {
        model.addAttribute("id", id);
        return "rightsActivity/rightsActivity-allowList-import";
    }

    /**
     * 白名单导入
     *
     * @param file
     * @param rightsActivityId
     * @return
     * @throws IOException
     * @throws ParamException
     */
    @PostMapping("/allowListImport")
    @ResponseBody
    public JsonResult allowListImport(MultipartFile file, Integer rightsActivityId) throws IOException, ParamException {
        int count = service.allowListImport(file, rightsActivityId);
        return JsonResult.success(String.format("导入成功！共计 %s 条", count));
    }
}
