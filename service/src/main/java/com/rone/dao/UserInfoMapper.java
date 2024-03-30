package com.rone.dao;

import com.rone.entity.UserInfo;
import com.rone.entity.UserInfoCriteria;
import com.rone.entity.UserToken;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 客户
 *
 * @author rone
 */
@Mapper
public interface UserInfoMapper {
    long countByExample(UserInfoCriteria example);

    int deleteByExample(UserInfoCriteria example);

    int deleteByPrimaryKey(String wuiCustNo);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    List<UserInfo> selectByExample(UserInfoCriteria example);

    UserInfo selectByPrimaryKey(String wuiCustNo);

    int updateByExampleSelective(@Param("record") UserInfo record, @Param("example") UserInfoCriteria example);

    int updateByExample(@Param("record") UserInfo record, @Param("example") UserInfoCriteria example);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    /**
     * 检测手机号码是否重复绑定
     *
     * @param mobileNo
     * @param exceptStatus
     * @return
     * @author rone
     */
    long checkMobileUsed(@Param("mobileNo") String mobileNo, @Param("exceptStatus") String exceptStatus);

    /**
     * 更新用户的Token
     *
     * @param userId
     * @param userToken
     * @param sessionId
     * @param createTime
     * @param expireTime
     * @param serverIp
     * @return
     */
    int updateUserToken(@Param("userId") String userId, @Param("userToken") String userToken, @Param("sessionId") String sessionId, @Param("createTime") Date createTime, @Param("expireTime") Date expireTime, @Param("serverIp") String serverIp);

    /**
     * 新增一个用户Token
     *
     * @param userId
     * @param userToken
     * @param sessionId
     * @param createTime
     * @param expireTime
     * @param serverIp
     * @return
     */
    int insertUserToken(@Param("userId") String userId, @Param("userToken") String userToken, @Param("sessionId") String sessionId, @Param("createTime") Date createTime, @Param("expireTime") Date expireTime, @Param("serverIp") String serverIp);

    /**
     * 获取用户Token
     *
     * @param userToken
     * @return
     */
    UserToken selectSingleUserToken(@Param("userToken") String userToken);

    /**
     * 刷新Token时效
     *
     * @param userId
     * @param expireTime
     * @return
     */
    int refreshUserToken(@Param("userId") String userId, @Param("expireTime") Date expireTime);
}