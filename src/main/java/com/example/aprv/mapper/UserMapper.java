package com.example.aprv.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface UserMapper {

    Map<String,Object> getLogin();
}
