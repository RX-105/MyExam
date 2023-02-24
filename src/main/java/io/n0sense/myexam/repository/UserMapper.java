package io.n0sense.myexam.repository;

import io.n0sense.myexam.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
    @Select("select * from user where username=#{username}")
    @Results(id = "userMapping", value = {
            @Result(property = "user_id", column = "user_id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password")
    })
    User findByUsername(@Param("username") String username);
    @Insert("insert into user(username, password) values(#{username}, #{password})")
    void save(User user);
    @Select("select (count(*)>0) from user where username=#{username}")
    boolean existsByUsername(@Param("username") String username);
}
