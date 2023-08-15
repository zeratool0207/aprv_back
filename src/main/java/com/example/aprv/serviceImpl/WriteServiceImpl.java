package com.example.aprv.serviceImpl;

import com.example.aprv.mapper.UserMapper;
import com.example.aprv.mapper.WriteMapper;
import com.example.aprv.service.WriteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WriteServiceImpl implements WriteService {

    private WriteMapper writeMapper;

    public WriteServiceImpl(WriteMapper writeMapper) {
        this.writeMapper = writeMapper;
    }


    @Override
    public List<Map<String, Object>> getList(String brd_id) {
        return writeMapper.getList(brd_id);
    }

    @Override
    public List<Map<String, Object>> getBoardView(String brd_id) {
        return writeMapper.getBoardView(brd_id);
    }
}
