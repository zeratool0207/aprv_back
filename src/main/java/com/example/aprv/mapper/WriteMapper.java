package com.example.aprv.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface WriteMapper {

    List<Map<String,Object>> getList(String brd_id);

    List<Map<String,Object>> getBoardView(String brd_id);

    int goNextBrdId();

    int goBoardInsert(Map<String,Object> param);

    int goHistoryInsert(String brd_id);

}
