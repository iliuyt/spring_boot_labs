package com.example.lab4_filter.Filters;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * @Description: TODO
 * @author: liuyt
 * @date: 2020年11月17日 2:01 下午
 */
public class CustomFilter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("timer CustomFilter2 is inited");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("timer CustomFilter2 begin");
        long start=new Date().getTime();
        filterChain.doFilter(servletRequest, servletResponse);
        long end=new Date().getTime();
        System.out.println("timer CustomFilter2 end,cost time:"+(end-start));
    }

    @Override
    public void destroy() {
        System.out.println("timer CustomFilter2 is destoried");
    }
}