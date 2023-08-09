package com.example.aprv.service;

import java.util.List;
import java.util.Map;

public interface BoardService {

    List<Map<String,Object>> getList(String userId);
}
