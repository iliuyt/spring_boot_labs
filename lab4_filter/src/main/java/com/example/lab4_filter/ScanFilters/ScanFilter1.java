package com.example.lab4_filter.ScanFilters;


import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Date;

/**
 * @Description: TODO
 * @author: liuyt
 * @date: 2020年11月17日 1:33 下午
 */

public class ScanFilter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("timer MyFilter is inited");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("timer MyFilter begin");
        long start=new Date().getTime();
        filterChain.doFilter(servletRequest, servletResponse);
        long end=new Date().getTime();
        System.out.println("timer MyFilter end,cost time:"+(end-start));
    }

    @Override
    public void destroy() {
        System.out.println("timer MyFilter is destoried");
    }
}
