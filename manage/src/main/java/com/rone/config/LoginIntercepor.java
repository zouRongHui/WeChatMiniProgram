package com.rone.config;

import com.rone.entity.AdminUserInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录拦截器
 *
 * @author rone
 */
@Component
public class LoginIntercepor implements HandlerInterceptor {

    /**
     * 需要权限的请求链接
     */
    private Map<String, String> permissionMap;

    @PostConstruct
    private void init() {
        permissionMap = new HashMap<>(64);

        permissionMap.put("/user/list", "ROLE_USER");
        permissionMap.put("/user/add", "ROLE_USER");
        permissionMap.put("/user/edit", "ROLE_USER");
        permissionMap.put("/user/passwordrefresh", "ROLE_USER");
        permissionMap.put("/user/stop", "ROLE_USER");
        permissionMap.put("/user/start", "ROLE_USER");
        permissionMap.put("/user/delete", "ROLE_USER");

        permissionMap.put("/role/list", "ROLE_ROLE");
        permissionMap.put("/role/add", "ROLE_ROLE");
        permissionMap.put("/role/edit", "ROLE_ROLE");

        permissionMap.put("/sysparam/list", "ROLE_SYS_PARAM");
        permissionMap.put("/sysparam/add", "ROLE_SYS_PARAM");
        permissionMap.put("/sysparam/edit", "ROLE_SYS_PARAM");
        permissionMap.put("/sysparam/stop", "ROLE_SYS_PARAM");
        permissionMap.put("/sysparam/start", "ROLE_SYS_PARAM");
        permissionMap.put("/sysparam/delete", "ROLE_SYS_PARAM");

        permissionMap.put("/blockUser/list", "ROLE_BLOCK_USER");
        permissionMap.put("/blockUser/addView", "ROLE_BLOCK_USER");
        permissionMap.put("/blockUser/add", "ROLE_BLOCK_USER");
        permissionMap.put("/blockUser/delete", "ROLE_BLOCK_USER");
        permissionMap.put("/blockUser/usable", "ROLE_BLOCK_USER");
        permissionMap.put("/blockUser/disable", "ROLE_BLOCK_USER");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        AdminUserInfo adminUserInfo = (AdminUserInfo) session.getAttribute("userInfo");
        if (adminUserInfo == null) {
            response.sendRedirect("/auth/login");
            return false;
        } else {
            if ("/".equals(request.getRequestURI())) {
                response.sendRedirect("/auth/index");
                return false;
            }
            if (StringUtils.isNotEmpty(permissionMap.get(request.getRequestURI()))) {
                if (adminUserInfo.getPermissionCodeSet().contains(permissionMap.get(request.getRequestURI()))) {
                    return true;
                }
                response.setStatus(HttpStatus.SC_FORBIDDEN);
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("<h3 style='color: red;'>您无权访问！</h3>");
                return false;
            }
            return true;
        }
    }
}
