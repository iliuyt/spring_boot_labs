package com.example.lab7_bean.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: TODO
 * @author: liuyt
 * @date: 2020年11月23日 2:07 下午
 */

@Configuration
public class MyBeanConfig {

    @Bean(name = "tt")
    public DefaultMyBean getMyBeanTt() {
        DefaultMyBean defaultMyBean = new DefaultMyBean();
        defaultMyBean.setName("Tt");
        return defaultMyBean;
    }

    @Bean(name = "tm")
    public DefaultMyBean getMyBeanTm() {
        DefaultMyBean defaultMyBean = new DefaultMyBean();
        defaultMyBean.setName("Tm");
        return defaultMyBean;
    }
}
