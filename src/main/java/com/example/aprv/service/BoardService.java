package com.example.aprv.service;

import java.util.List;
import java.util.Map;

public interface BoardService {

    List<Map<String,Object>> getList(String userId);

    // 검색타입
    // 선택, 작성자, 결재자, 제목 + 내용

    // 결재상태
    // 임시저장, 결재대기, 결재중, 결재완료, 반려
    List<Map<String,Object>> getCode(String upCode);



}
