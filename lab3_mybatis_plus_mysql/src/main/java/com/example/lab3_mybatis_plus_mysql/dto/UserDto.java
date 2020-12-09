package com.example.lab3_mybatis_plus_mysql.dto;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @Description: TODO
 * @author: liuyt
 * @date: 2020年11月09日 3:09 下午
 */
@Data
@TableName(value = "users")
public class UserDto {
    /**
     * 用户编号
     */
    private Integer id;
    /**
     * 账号
     */
    private String username;

    private Integer sex;

    private Integer age;

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