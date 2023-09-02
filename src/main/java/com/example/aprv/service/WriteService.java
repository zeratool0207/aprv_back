package com.example.aprv.service;

import java.util.List;
import java.util.Map;

public interface WriteService {

    List<Map<String,Object>> getList(String brd_id);

    List<Map<String,Object>> getBoardView(String brd_id);

    int goNextBrdId();

    int goBoardInsert(Map<String,Object> param);

//    int goHistoryInsert(Map<String,Object> param);

}
