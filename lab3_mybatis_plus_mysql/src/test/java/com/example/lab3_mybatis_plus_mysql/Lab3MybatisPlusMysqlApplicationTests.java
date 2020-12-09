package com.example.lab3_mybatis_plus_mysql;

import com.example.lab3_mybatis_plus_mysql.dto.UserDto;
import com.example.lab3_mybatis_plus_mysql.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RunWith(value = SpringRunner.class)
@SpringBootTest(classes = Lab3MybatisPlusMysqlApplication.class)
class Lab3MybatisPlusMysqlApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void insertTest() {
        UserDto userDto = new UserDto();
        userDto.setUsername("test");
        userDto.setCreateTime(new Date());
        userDto.setSex(1);
        userDto.setAge(10);
        userDto.setPassword("123456");
        userMapper.insert(userDto);
    }

    @Test
    void selectNameTest() {
        userMapper.selectByUsername("test");
    }

    @Test
    void selectAgeOrSex() {
        List<UserDto> userDtos = userMapper.selectBySexOrAge(1, 11);
        System.out.print(userDtos.size());
    }

    @Test
    void customSelect() {
        List<UserDto> userDtos = userMapper.selectById2(4);
        System.out.print(userDtos.size());
    }

    @Test
    void plusSelect() {
        UserDto userDto = userMapper.selectById(4);
        System.out.print(userDto.getUsername());
    }

}
