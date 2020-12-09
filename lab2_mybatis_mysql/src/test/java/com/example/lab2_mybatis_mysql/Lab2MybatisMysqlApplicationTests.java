package com.example.lab2_mybatis_mysql;

import com.example.lab2_mybatis_mysql.dto.UserDto;
import com.example.lab2_mybatis_mysql.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Lab2MybatisMysqlApplication.class)
class Lab2MybatisMysqlApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() {
        UserDto user = new UserDto();
        user.setUsername(UUID.randomUUID().toString());
        user.setCreateTime(new Date());
        userMapper.insert(user);
    }

    @Test
    public void testDeleteById() {
        userMapper.deleteById(2);
    }

    @Test
    public void testSelectById() {
        userMapper.selectById(1);
    }

}
