package org.rone.study.springBoot.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author: Rone   2020-01-09 10:06
 */
@Order(1)
@WebFilter(urlPatterns = {"/*"})
public class FirstFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(FirstFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.info("加载第一个过滤器");
        System.out.println();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        LOGGER.info(httpServletRequest.getRequestURI());
//        LOGGER.info("第一个过滤器启动");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        LOGGER.info("销毁第一个过滤器");
    }
}
