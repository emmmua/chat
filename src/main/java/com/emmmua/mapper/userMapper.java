package com.emmmua.mapper;

import com.emmmua.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface userMapper {

    User login(@Param("user") User user);

    void register(@Param("user") User user);

    User SelectByName(@Param("username") String username);
}
