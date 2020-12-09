package com.example.lab1_security.config;

import com.example.lab1_security.Dto.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Description: TODO
 * @author: liuyt
 * @date: 2020年11月10日 1:41 下午
 */
@Repository
public class UserDetailsServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!"admin".equals(username)) {
            throw new UsernameNotFoundException("用户名找不到");
        }

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
        return new LoginUser(user, authorities);
    }
}
