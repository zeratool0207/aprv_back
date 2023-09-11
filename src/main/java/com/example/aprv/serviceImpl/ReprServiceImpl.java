package com.example.aprv.serviceImpl;

import com.example.aprv.mapper.ReprMapper;
import com.example.aprv.service.ReprService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReprServiceImpl implements ReprService {

    private final ReprMapper reprMapper;

    public ReprServiceImpl(ReprMapper reprMapper) {
        this.reprMapper = reprMapper;
    }

    @Override
    public List<Map<String, Object>> getPosition(String position) {
        return reprMapper.getPosition(position);
    }

    @Override
    public List<Map<String, Object>> getUser(String position) {
        return reprMapper.getUser(position);
    }

    @Override
    public List<Map<String, Object>> getBoard() {
        return reprMapper.getBoard();
    }
}
