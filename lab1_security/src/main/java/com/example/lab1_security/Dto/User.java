package com.example.lab1_security.Dto;

import lombok.Data;

import java.util.List;

/**
 * @Description: TODO
 * @author: liuyt
 * @date: 2020年11月10日 1:43 下午
 */
@Data
public class User {
    private String username;
    private String password;
    private String id;
    private List<String> roles;
}
