package com.example.lab2_mybatis_mysql.dto;

import lombok.Data;

import java.util.Date;

/**
 * @Description: TODO
 * @author: liuyt
 * @date: 2020年11月09日 3:09 下午
 */
@Data
public class UserDto {
    /**
     * 用户编号
     */
    private Integer id;
    /**
     * 账号
     */
    private String username;
    /**
     * 密码（明文）
     * <p>
     * ps：生产环境下，千万不要明文噢
     */
    private String password;
    /**
     * 创建时间
     */
    private Date createTime;


}
