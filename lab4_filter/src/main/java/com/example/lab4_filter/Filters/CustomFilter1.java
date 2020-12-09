package com.example.lab4_filter.Filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;

/**
 * @Description: TODO
 * @author: liuyt
 * @date: 2020年11月17日 2:01 下午
 */
public class CustomFilter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("timer CustomFilter1 is inited");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        // 遍历header name
        Enumeration<String> enumeration = request.getHeaderNames();
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement().toString());
        }

        // 设置header
        response.setHeader("token","xxxx");

        long start = new Date().getTime();
        filterChain.doFilter(request, response);
        long end = new Date().getTime();
        System.out.println("timer CustomFilter1 end,cost time:" + (end - start));
    }

    @Override
    public void destroy() {
        System.out.println("timer CustomFilter1 is destoried");
    }
}