package com.example.lab2_mybatis_mysql.mapper;

import com.example.lab2_mybatis_mysql.dto.UserDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface UserMapper {

    int insert(UserDto user);

    int updateById(UserDto user);

    int deleteById(@Param("id") Integer id); // 生产请使用标记删除，除非有点想不开，嘿嘿。

    UserDto selectById(@Param("id") Integer id);

    UserDto selectByUsername(@Param("username") String username);

    List<UserDto> selectByIds(@Param("ids") Collection<Integer> ids);

}
