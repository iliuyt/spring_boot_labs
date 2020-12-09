package com.example.lab3_mybatis_plus_mysql.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.lab3_mybatis_plus_mysql.dto.UserDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: TODO
 * @author: liuyt
 * @date: 2020年11月09日 4:04 下午
 */
@Repository
public interface UserMapper extends BaseMapper<UserDto> {

    List<UserDto> selectById2(@Param("id") Integer id);


    default UserDto selectByUsername(@Param("username") String username) {
        QueryWrapper<UserDto> queryWrapper = new QueryWrapper<UserDto>();
        queryWrapper.eq("username", username);
        return selectOne(queryWrapper);
    }

    default List<UserDto> selectBySexOrAge(@Param("sex") Integer sex, @Param("age") Integer age) {
        QueryWrapper<UserDto> queryWrapper = new QueryWrapper<UserDto>();
        queryWrapper.eq("sex", sex).or().lt("age", age).orderByDesc("id");
        return selectList(queryWrapper);
    }

}
