package com.kert.compute.dao;

import com.kert.compute.model.entity.LogInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogMapper {
    @Insert("insert into api_logs(client_ip,request,response) values(#{clientIP},#{request},#{response})")
    void insert(LogInfo logInfo);
}
