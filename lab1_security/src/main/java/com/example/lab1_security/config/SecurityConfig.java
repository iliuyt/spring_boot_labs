package com.example.lab1_security.config;

import com.example.lab1_security.Filters.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.NoOp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @Description: TODO
 * @author: liuyt
 * @date: 2020年11月10日 1:18 下午
 */

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    // 通过内存判断账号密码
    //@Override
    //protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //    auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
    //            .withUser("admin").password("admin").roles("admin")
    //            .and()
    //            .withUser("admin2").password("admin2").roles("admin2");
    //}

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().csrf().disable().authorizeRequests().antMatchers("/hello/a").anonymous()
                // hasRole和hasAuthority的区别在于 角色前面要增加ROLE_ 历史遗留问题，
                // 作者的目的是 hasRole是角色(权限集合)判断，hasAuthority是权限判断
                // 我们默认使用hasAuthority即可
                // 在Spring Security4 之前两者作用一样，不需要加ROLE_
                .antMatchers("/hello/b").hasAuthority("admin").antMatchers("/hello/c").hasAuthority("admin2")
                // 除上面外的所有请求全部需要鉴权认证
                .anyRequest().authenticated().and().formLogin().permitAll().and().logout().permitAll();
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }


}
