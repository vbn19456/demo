package com.kert.compute.dao;

import com.kert.compute.model.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {
    @Select("select count(1) from t_user where name=#{name} and pwd=#{pwd}")
    int selectCount(User user);
}
