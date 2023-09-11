package com.example.aprv.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ReprMapper {

    List<Map<String,Object>> getPosition(String position);

    List<Map<String,Object>> getUser(String position);

    List<Map<String,Object>> getBoard();


}
