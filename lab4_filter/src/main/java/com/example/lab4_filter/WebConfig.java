package com.example.lab4_filter;

import com.example.lab4_filter.Filters.CustomFilter1;
import com.example.lab4_filter.Filters.CustomFilter2;
import com.example.lab4_filter.Filters.CustomFilter3;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: TODO
 * @author: liuyt
 * @date: 2020年11月17日 2:16 下午
 */

@Configuration
public class WebConfig {
    @Bean
    public FilterRegistrationBean reqResFilter1() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();

        CustomFilter1 customFilter1 = new CustomFilter1();
        filterRegistrationBean.setFilter(customFilter1);
        filterRegistrationBean.setName("customFilter1");//设置过滤器名称
        filterRegistrationBean.setOrder(33);//执行次序
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean reqResFilter2() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        CustomFilter2 customFilter2 = new CustomFilter2();
        filterRegistrationBean.setFilter(customFilter2);
        filterRegistrationBean.setName("customFilter2");//设置过滤器名称
        filterRegistrationBean.setOrder(22);//执行次序
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean reqResFilter3() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        CustomFilter3 customFilter3 = new CustomFilter3();
        filterRegistrationBean.setFilter(customFilter3);
        filterRegistrationBean.setName("customFilter3");//设置过滤器名称
        filterRegistrationBean.setOrder(11);//执行次序
        return filterRegistrationBean;
    }
}
