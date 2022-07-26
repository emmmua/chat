package com.emmmua.mapper;

import com.emmmua.pojo.Moments;
import com.emmmua.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface momentsMapper {
    List<Moments> selectAll();

    @Select("select * from user where id = #{id}")
    User selectById(@Param("id") int id);

    @Delete("delete from moments where number = #{number}")
    int DeleteById(@Param("number") long number);

    @Insert("insert into moments(number, text, dep_id, time) value(null, #{moments.text}, #{moments.depId}, #{moments.time})")
    int InsertMoments(@Param("moments") Moments moments);
}
