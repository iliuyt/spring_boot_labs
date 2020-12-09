package com.example.lab1_security.Filters;

import com.example.lab1_security.Dto.User;
import com.example.lab1_security.config.LoginUser;
import com.example.lab1_security.config.UserDetailsServiceImpl;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * @Description: TODO
 * @author: liuyt
 * @date: 2020年11月17日 11:14 上午
 */

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {


    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("过滤器");
        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //request.getHeaders("Authorization");
        //if ()

        //LoginUser loginUser = tokenService.getLoginUser(request);
        //if (StringUtils.isNotNull(loginUser) && StringUtils.isNull(SecurityUtils.getAuthentication()))
        //{
        //    tokenService.verifyToken(loginUser);
        //    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());
        //    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        //    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        //}
        //chain.doFilter(request, response);
        //

        if (SecurityContextHolder.getContext().getAuthentication() == null) {

            User user = new User();
            user.setId("1");
            user.setUsername("admin");
            user.setPassword("admin");

            List<String> roles = new ArrayList<>();
            roles.add("admin");
            roles.add("ROLE_admin");
            user.setRoles(roles);

            Set<GrantedAuthority> authorities = new HashSet<>();
            if (user.getRoles() != null) {
                authorities = user.getRoles().stream().map(v -> new SimpleGrantedAuthority(v)).collect(Collectors.toSet());
            }
            LoginUser loginUser = new LoginUser(user, authorities);
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        chain.doFilter(request, response);
    }
}
