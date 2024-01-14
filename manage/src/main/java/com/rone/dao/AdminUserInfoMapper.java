package com.rone.dao;

import com.rone.entity.AdminLoginLog;
import com.rone.entity.AdminUserInfo;
import com.rone.entity.AdminUserInfoCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 用户
 *
 * @author rone
 */
@Mapper
public interface AdminUserInfoMapper {
    Integer countByExample(AdminUserInfoCriteria example);

    int deleteByExample(AdminUserInfoCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(AdminUserInfo record);

    int insertSelective(AdminUserInfo record);

    List<AdminUserInfo> selectByExample(AdminUserInfoCriteria example);

    AdminUserInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AdminUserInfo record, @Param("example") AdminUserInfoCriteria example);

    int updateByExample(@Param("record") AdminUserInfo record, @Param("example") AdminUserInfoCriteria example);

    int updateByPrimaryKeySelective(AdminUserInfo record);

    int updateByPrimaryKey(AdminUserInfo record);

    /**
     * 查询列表数据
     *
     * @param userName 用户名称
     * @return
     */
    List<AdminUserInfo> getPageList(@Param("userName") String userName);

    int insertLoginLog(AdminLoginLog loginLog);

    List<AdminLoginLog> getFailLoginLogInTime(@Param("account") String account, @Param("time") Date time);
}