package com.rone.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rone.dao.RightsActivityAllowListMapper;
import com.rone.dao.RightsActivityMapper;
import com.rone.entity.*;
import com.rone.enumeration.RightsActivityStatusEnum;
import com.rone.enumeration.YesOrNoEnum;
import com.rone.exception.ParamException;
import com.rone.exception.RoneException;
import com.rone.manager.MiniAppCodeManager;
import com.rone.qo.RightsActivityQO;
import com.rone.service.RightsActivityService;
import com.rone.utils.ExcelUtils;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

/**
 * 权益活动配置
 *
 * @author rone
 */
@Service
@Transactional
public class RightsActivityServiceImpl implements RightsActivityService {

    /**
     * 小程序的权益活动宣传页面地址
     */
    public static final String MINI_APP_PAGE_PATH = "pages/rights/rights";

    @Resource
    private RightsActivityMapper mapper;
    @Autowired
    private MiniAppCodeManager miniAppCodeManager;
    @Resource
    private RightsActivityAllowListMapper allowListMapper;

    @Override
    public PageInfo<RightsActivity> pageList(RightsActivityQO qo) {
        RightsActivityCriteria rightsActivityCriteria = new RightsActivityCriteria();
        RightsActivityCriteria.Criteria criteria = rightsActivityCriteria.createCriteria();

        if (StringUtils.isNotEmpty(qo.getTitle())) {
            criteria.andTitleLike("%" + qo.getTitle() + "%");
        }

        criteria.andDeleteFlagEqualTo(YesOrNoEnum.NO.getCode());
        rightsActivityCriteria.setOrderByClause(" CREATE_TIME desc");
        if (qo.getPage() == null) {
            qo.setPage(1);
        }
        if (qo.getSize() == null) {
            qo.setSize(15);
        }
        if (qo.getSize() > 0) {
            PageHelper.startPage(qo.getPage(), qo.getSize());
        }
        List<RightsActivity> rightsActivityList = mapper.selectByExample(rightsActivityCriteria);
        return new PageInfo<>(rightsActivityList);
    }

    @Override
    public int add(RightsActivity rightsActivity) {
        rightsActivity.setReceiveTimesDone(0);
        if (rightsActivity.getReceiveTimesTotal() != null && rightsActivity.getReceiveTimesTotal() > 0) {
            rightsActivity.setReceiveTimesSurplus(rightsActivity.getReceiveTimesTotal());
        }
        rightsActivity.setStatus(RightsActivityStatusEnum.DISABLE.getCode());
        rightsActivity.setCreateTime(new Date());
        rightsActivity.setDeleteFlag(YesOrNoEnum.NO.getCode());
        return mapper.insert(rightsActivity);
    }

    @Override
    public RightsActivity findById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int edit(RightsActivity rightsActivity) throws RoneException {
        RightsActivity oldRightsActivity = mapper.selectByPrimaryKey(rightsActivity.getId());
        if (oldRightsActivity == null || YesOrNoEnum.YES.getCode().equals(oldRightsActivity.getDeleteFlag())) {
            throw new ParamException("修改失败：该权益活动不存在！");
        }
        if (RightsActivityStatusEnum.USABLE.getCode().equals(oldRightsActivity.getStatus())) {
            throw new RoneException("修改失败：该权益活动已启用无法修改，请先停用再修改！");
        }

        rightsActivity.setReceiveTimesDone(oldRightsActivity.getReceiveTimesDone());
        if (rightsActivity.getReceiveTimesTotal() != null && rightsActivity.getReceiveTimesTotal() > 0) {
            rightsActivity.setReceiveTimesSurplus(rightsActivity.getReceiveTimesTotal() - rightsActivity.getReceiveTimesDone());
        }
        rightsActivity.setStatus(oldRightsActivity.getStatus());
        rightsActivity.setCreateTime(oldRightsActivity.getCreateTime());
        rightsActivity.setDeleteFlag(oldRightsActivity.getDeleteFlag());

        return mapper.updateByPrimaryKey(rightsActivity);
    }

    @Override
    public int delete(Integer... ids) {
        RightsActivity rightsActivity = new RightsActivity();
        rightsActivity.setDeleteFlag(YesOrNoEnum.YES.getCode());
        RightsActivityCriteria rightsActivityCriteria = new RightsActivityCriteria();
        rightsActivityCriteria.createCriteria().andIdIn(Arrays.asList(ids));
        return mapper.updateByExampleSelective(rightsActivity, rightsActivityCriteria);
    }

    @Override
    public int usable(Integer id) throws RoneException {
        RightsActivity rightsActivity = mapper.selectByPrimaryKey(id);
        if (rightsActivity == null || YesOrNoEnum.YES.getCode().equals(rightsActivity.getDeleteFlag())) {
            throw new ParamException("启用失败：该权益活动不存在！");
        }
        if (rightsActivity.getReceiveTimesTotal() != null) {
            if (rightsActivity.getReceiveTimesDone() >= rightsActivity.getReceiveTimesTotal()) {
                throw new RoneException("启用失败：该权益已经全被领取无法启用，请先修改领取上限！");
            }
        }
        rightsActivity.setStatus(RightsActivityStatusEnum.USABLE.getCode());
        return mapper.updateByPrimaryKey(rightsActivity);
    }

    @Override
    public int disable(Integer id) throws ParamException {
        RightsActivity rightsActivity = mapper.selectByPrimaryKey(id);
        if (rightsActivity == null || YesOrNoEnum.YES.getCode().equals(rightsActivity.getDeleteFlag())) {
            throw new ParamException("停用失败：该权益活动不存在！");
        }
        rightsActivity.setStatus(RightsActivityStatusEnum.DISABLE.getCode());
        return mapper.updateByPrimaryKey(rightsActivity);
    }

    @Override
    public String getRightsActivityMiniAppCode(Integer id) throws RoneException, IOException, URISyntaxException {
        if (id == null) {
            return "";
        }
        RightsActivity rightsActivity = mapper.selectByPrimaryKey(id);
        if (rightsActivity == null || YesOrNoEnum.YES.getCode().equals(rightsActivity.getDeleteFlag())) {
            return "";
        }

        MiniAppCode miniAppCode = miniAppCodeManager.getByPagePath(MINI_APP_PAGE_PATH, String.valueOf(rightsActivity.getId()));

        return miniAppCode.getCodeUrl();
    }

    @Override
    public PageInfo<RightsActivityAllowList> allowListPageList(Integer pageNum, Integer pageSize, Integer id, String phone) {
        RightsActivityAllowListCriteria rightsActivityAllowListCriteria = new RightsActivityAllowListCriteria();
        RightsActivityAllowListCriteria.Criteria criteria = rightsActivityAllowListCriteria.createCriteria();
        criteria.andRightsActivityIdEqualTo(id);
        if (StringUtils.isNotEmpty(phone)) {
            criteria.andPhoneLike("%" + phone + "%");
        }
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        PageHelper.startPage(pageNum, pageSize);
        List<RightsActivityAllowList> rightsActivityAllowListList = allowListMapper.selectByExample(rightsActivityAllowListCriteria);
        return new PageInfo<>(rightsActivityAllowListList);
    }

    @Override
    public int allowListAdd(RightsActivityAllowList rightsActivityAllowList) throws RoneException {
        if (rightsActivityAllowList.getRightsActivityId() == null || StringUtils.isEmpty(rightsActivityAllowList.getPhone())) {
            throw new RoneException("权益白名单添加失败，数据缺失");
        }
        return allowListMapper.insert(rightsActivityAllowList);
    }

    @Override
    public int allowListDelete(String[] phones, Integer rightsActivityId) throws RoneException {
        if (phones == null || phones.length == 0 || rightsActivityId == null) {
            throw new RoneException("权益白名单删除失败，要删除的白名单不存在！");
        }
        int result = 0;
        List<List<String>> phoneListList = ListUtils.partition(Arrays.asList(phones), 1000);
        for (List<String> phoneList : phoneListList) {
            RightsActivityAllowListCriteria rightsActivityAllowListCriteria = new RightsActivityAllowListCriteria();
            rightsActivityAllowListCriteria.createCriteria().andRightsActivityIdEqualTo(rightsActivityId).andPhoneIn(phoneList);
            result += allowListMapper.deleteByExample(rightsActivityAllowListCriteria);
        }

        return result;
    }

    @Override
    public int allowListDeleteAll(Integer rightsActivityId) throws RoneException {
        if (rightsActivityId == null) {
            throw new RoneException("权益白名单删除失败，要删除的白名单不存在！");
        }
        RightsActivityAllowListCriteria rightsActivityAllowListCriteria = new RightsActivityAllowListCriteria();
        rightsActivityAllowListCriteria.createCriteria().andRightsActivityIdEqualTo(rightsActivityId);

        return allowListMapper.deleteByExample(rightsActivityAllowListCriteria);
    }

    @Override
    public int allowListImport(MultipartFile file, Integer rightsActivityId) throws ParamException, IOException {
        String originalFilename = Objects.requireNonNull(file.getOriginalFilename()).toLowerCase();
        if (!(originalFilename.endsWith(".xlsx") || originalFilename.endsWith(".xls"))) {
            throw new ParamException("文件格式不对，只支持 xlsx、xls 两种格式的文件");
        }
        Workbook workbook = null;
        if (originalFilename.endsWith(".xlsx")) {
            workbook = new XSSFWorkbook(file.getInputStream());
        } else if (originalFilename.endsWith(".xls")) {
            workbook = new HSSFWorkbook(file.getInputStream());
        }

        Sheet sheet = workbook.getSheetAt(0);
        List<RightsActivityAllowList> rightsActivityAllowListList = new ArrayList<>(sheet.getLastRowNum());
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row == null) {
                continue;
            }
            RightsActivityAllowList rightsActivityAllowList = new RightsActivityAllowList();
            rightsActivityAllowList.setRightsActivityId(rightsActivityId);
            rightsActivityAllowList.setPhone(ExcelUtils.getCellValue(row.getCell(0)));
            rightsActivityAllowListList.add(rightsActivityAllowList);
        }
        // 批量插入ORACLE执行语句有最大长度限制
        int result = 0;
        List<List<RightsActivityAllowList>> subList = ListUtils.partition(rightsActivityAllowListList, 500);
        for (List<RightsActivityAllowList> list : subList) {
            result += allowListMapper.batchInsert(list);
        }
        return result;
    }
}
