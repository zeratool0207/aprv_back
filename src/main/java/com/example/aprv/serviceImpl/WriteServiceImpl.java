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

    @Override
    public int goNextBrdId() {
        return writeMapper.goNextBrdId();
    }

    @Override
    public int goBoardInsert(Map<String,Object> param) {
        System.out.println("this is param: "+ param);
        return writeMapper.goBoardInsert(param);
    }

    @Override
    public int goHistoryInsert(String brd_id) {
        return writeMapper.goHistoryInsert(brd_id);
    }

//    @Override
//    public int goHistoryInsert(Map<String,Object> param) {
//        return writeMapper.goHistoryInsert(param);
//    }


}
