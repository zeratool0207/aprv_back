package com.example.aprv.service;

import java.util.List;
import java.util.Map;

public interface ReprService {

    List<Map<String,Object>> getPosition(String position);

    List<Map<String,Object>> getUser(String position);

    List<Map<String,Object>> getBoard();


}
