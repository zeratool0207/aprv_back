package com.example.aprv.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {

    List<Map<String,Object>> getList(String userId);

    List<Map<String,Object>> getCode(String upCode);
}
