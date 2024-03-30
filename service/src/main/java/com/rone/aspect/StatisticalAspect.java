package com.rone.aspect;

import com.alibaba.fastjson.JSON;
import com.rone.exception.SessionDueException;
import com.rone.exception.RoneException;
import com.rone.utils.CustomlWebUtils;
import com.rone.vo.Result;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 请求数据统计
 *
 * @author rone
 */
@Order(0)
@Aspect
@Component
public class StatisticalAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(StatisticalAspect.class);

    /**
     * 切点配置
     */
    private static final String POINT_CUT_STR = "execution(* com.rone.controller.*..*(..))";

    @Around(value = POINT_CUT_STR)
    public Object around(ProceedingJoinPoint joinPoint) {
        Object result;
        Date requestTime = new Date();
        try {
            result = joinPoint.proceed();
        } catch (SessionDueException e) {
            result = Result.sessionDue();
        } catch (RoneException e) {
            result = Result.fault(e.getMessage());
        } catch (Throwable throwable) {
            LOGGER.error(throwable.getMessage(), throwable);
            result = Result.fault("系统出错，请稍后再试！", "详见日志");
        }
        // 统计、处理返回的数据
        statistical(joinPoint, result, requestTime);
        return result;
    }

    /**
     * 登记请求的信息
     *
     * @param joinPoint
     * @param result
     * @param requestTime
     */
    private void statistical(JoinPoint joinPoint, Object result, Date requestTime) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        long total = System.currentTimeMillis() - requestTime.getTime();
        String requestParam = null;
        Object[] args = joinPoint.getArgs();
        if (args != null) {
            requestParam = JSON.toJSONString(args);
        }

        // 请求详情打印到日志
        LOGGER.info("请求URL：{}，请求IP：{}，请求耗时：{} 毫秒\n请求参数：{}\n响应数据：{}\n", request.getRequestURI(), CustomlWebUtils.getIpAddress(request), total, requestParam, JSON.toJSONString(result));
    }
}
