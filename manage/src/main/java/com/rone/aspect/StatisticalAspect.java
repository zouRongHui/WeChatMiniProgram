package com.rone.aspect;

import com.alibaba.fastjson.JSON;
import com.rone.entity.AdminUserInfo;
import com.rone.service.SysParamService;
import com.rone.utils.CustomlWebUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * 统计请求耗时
 *
 * @author rone
 */
@Aspect
@Component
public class StatisticalAspect {

    private static final Logger logger = LoggerFactory.getLogger(StatisticalAspect.class);
    // ThreadLocal 维护变量 避免同步
    // ThreadLocal为每个使用该变量的线程提供独立的变量副本，所以每一个线程都可以独立地改变自己的副本，而不会影响其它线程所对应的副本。
    private final ThreadLocal<Long> startTime = new ThreadLocal<>();// 开始时间

    /**
     * 切点配置
     */
    private static final String POINT_CUT_STR = "execution(* com.rone.controller.*..*(..))";

    @Autowired
    private SysParamService sysParamService;

    /**
     * 对Controller下面的方法执行前进行切入，初始化开始时间并设置序号
     *
     * @param jp
     */
    @Before(value = POINT_CUT_STR)
    public void beforeMethod(JoinPoint jp) {
        startTime.set(System.currentTimeMillis());
    }


    /**
     * 对Controller下面的方法执行后进行切入，统计方法执行的次数和耗时情况
     * 注意，这里的执行方法统计的数据不止包含Controller下面的方法，也包括环绕切入的所有方法的统计信息
     *
     * @param joinPoint
     * @param result
     */
    @AfterReturning(value = POINT_CUT_STR, returning = "result")
    public void afterMethod(JoinPoint joinPoint, Object result) {
        try {
            String seq = UUID.randomUUID().toString();

            String targetClassName = joinPoint.getSignature().getDeclaringTypeName();
            String methodName = joinPoint.getSignature().getName();

            HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
            AdminUserInfo adminUserInfo = (AdminUserInfo) request.getSession().getAttribute("userInfo");

            Map<String, String[]> parameterMap = request.getParameterMap();
            int paramSize = parameterMap.size();

            String returnType = joinPoint.getSignature().toString().split(" ")[0];

            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            long end = System.currentTimeMillis();
            long total = end - startTime.get();

            logger.info("类/接口:{}, 方法:{}, 序号:{} ", targetClassName, methodName, seq);
            if (adminUserInfo != null) {
                logger.info("操作用户:{}, 用户账号:{}, 序号:{} ", adminUserInfo.getUserName(), adminUserInfo.getAccount(), seq);
            }
            logger.info("参数个数:{}, 序号:{} ", paramSize, seq);
            if (paramSize > 0) {
                String logSensitiveData;
                try {
                    logSensitiveData = sysParamService.getSysParamValue("log_sensitive_data");
                } catch (Exception e) {
                    logSensitiveData = "";
                }
                StringBuilder param = new StringBuilder();
                for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
                    param.append(entry.getKey()).append(":");
                    if (logSensitiveData.contains(entry.getKey())) {
                        param.append("******");
                    } else {
                        param.append(JSON.toJSONString(entry.getValue()));
                    }
                    param.append(",");
                }
                logger.info("参数:{} 序号:{} ", param, seq);
            }
            logger.info("返回类型:{}, 序号:{} ", returnType, seq);

            if (result != null) {
                logger.info("返回值/页面路径:{}, 序号:{} ", JSON.toJSONString(result), seq);
            }
            logger.info("请求URL:{}, 请求ip:{}, 执行总耗时为:{}毫秒, 序号:{} ", attr.getRequest().getRequestURI(), CustomlWebUtils.getIpAddress(attr.getRequest()), total, seq);
        } catch (Exception e) {
            logger.error("日志信息收集出错，错误内容：{} ", e.getMessage(), e);
        }
    }
}
