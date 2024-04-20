package com.rone.aspect;

import com.rone.annotation.BlockUserCheck;
import com.rone.annotation.NeedLogon;
import com.rone.annotation.UserTypeValidation;
import com.rone.constant.HttpSessionAttributeConstant;
import com.rone.constant.WeChatMemoryCacheData;
import com.rone.enumeration.UserInfoTypeEnum;
import com.rone.exception.AuthException;
import com.rone.exception.SessionDueException;
import com.rone.exception.RoneException;
import com.rone.model.LogonUserInfo;
import com.rone.qo.CommonQO;
import com.rone.session.RoneSessionContext;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * 当前用户请求权限验证
 * 1.@NeedLogon 接口需要登录后才能操作
 * 2.@UserTypeValidation 接口需要判断用户类型
 * 3.@BlockUserCheck 接口有黑名单设置
 *
 * @author rone
 */
@Order(1)
@Aspect
@Component
public class AuthAspect {

    public static final Logger LOGGER = LoggerFactory.getLogger(AuthAspect.class);

    private static final String POINT_CUT_STR = "execution(* com.rone.controller.*..*(..))";

    @Before(value = POINT_CUT_STR)
    public void beforeMethod(JoinPoint joinPoint) throws RoneException {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        String sessionId = "";
        // 判断是否需要登录
        if (method.isAnnotationPresent(NeedLogon.class)) {
            sessionId = getSessionId(joinPoint);
            if (StringUtils.isEmpty(sessionId)) {
                throw new SessionDueException();
            }
            HttpSession session = RoneSessionContext.getInstance().getSession(sessionId);
            LogonUserInfo logonUserInfo = (LogonUserInfo) session.getAttribute(HttpSessionAttributeConstant.LOGON_USER_INFO);
            if (logonUserInfo == null) {
                throw new SessionDueException();
            }

            if (method.isAnnotationPresent(UserTypeValidation.class)) {
                UserTypeValidation userTypeValidation = method.getAnnotation(UserTypeValidation.class);
                boolean permissions = false;
                for (UserInfoTypeEnum userInfoTypeEnum : userTypeValidation.supportUserType()) {
                    if (userInfoTypeEnum.getCode().equals(logonUserInfo.getUserType())) {
                        permissions = true;
                        break;
                    }
                }
                if (!permissions) {
                    throw new RoneException("操作失败，请提升您的VIP登记！");
                }
            }

            if (method.isAnnotationPresent(BlockUserCheck.class)) {
                blockUserCheck(logonUserInfo);
            }
        }
    }

    /**
     * 黑名单检查
     *
     * @param logonUserInfo
     * @throws AuthException
     */
    private void blockUserCheck(LogonUserInfo logonUserInfo) throws AuthException {
        String phone = logonUserInfo.getWuiMobileNo();
        String openId = logonUserInfo.getWuiOpenid();
        if (WeChatMemoryCacheData.BLOCK_USER_CACHE_DATA.getOpenIdSet().contains(openId)) {
            throw new AuthException("【微信】操作过频繁！");
        }
        if (WeChatMemoryCacheData.BLOCK_USER_CACHE_DATA.getPhoneSet().contains(phone)) {
            throw new AuthException("【手机号】操作过频繁！");
        }
    }

    private String getSessionId(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        if (args != null) {
            for (Object arg : args) {
                if (arg instanceof CommonQO) {
                    return ((CommonQO) arg).getSessionId();
                }
            }
        }
        return null;
    }
}
