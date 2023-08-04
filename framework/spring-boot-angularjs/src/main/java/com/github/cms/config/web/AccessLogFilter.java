package com.github.cms.config.web;

import com.alibaba.fastjson2.JSON;
import com.github.cms.core.pojo.User;
import com.github.cms.core.util.IPAddressAnalysor;
import com.github.cms.core.util.SessionUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Kevin on 2016/10/11.
 */
@Component
public class AccessLogFilter implements Filter {

    private static final Logger logger = Logger.getLogger("Access Log");

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String accept = req.getHeader("Accept");
        if (accept != null && accept.matches("(application/json.*)|(\\*/\\*)")) {
            String ip = IPAddressAnalysor.getIPAddress(req);
            User sessionUser = SessionUtil.getSessionUser();
            String userName = sessionUser == null ? "" : "用户：" + sessionUser.getUserName();
            logger.info("**************************************\n" +
                    "IP：" + ip + " " + userName + "" + " 访问：" + req.getRequestURI() +
                    " 请求参数：" + JSON.toJSONString(req.getParameterMap()).replaceAll("\\[|\\]", ""));
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
