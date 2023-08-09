package com.example.aprv.serviceImpl;

import com.example.aprv.mapper.BoardMapper;
import com.example.aprv.service.BoardService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    public BoardServiceImpl(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    @Override
    public List<Map<String, Object>> getList(String userId) {
        return boardMapper.getList(userId);
    }
}
