package com.emmmua.mapper;

import com.emmmua.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface mainMapper {
    void reUser(@Param("user") User user);

    @Select("select * from user")
    List<User> SelectAll();
}
