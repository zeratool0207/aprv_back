package com.example.aprv.controller;

import com.example.aprv.service.BoardService;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/board")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/list")
    public List<Map<String, List<Map<String, Object>>>> getList(HttpSession session) {
        List<Map<String, List<Map<String, Object>>>> resultList = new ArrayList<>();

        List<Map<String, Object>> boardList = new ArrayList<>();
        List<Map<String,Object>> aprvStatusList = new ArrayList<>();
        List<Map<String,Object>> searchTypeList = new ArrayList<>();

        String userId = (String) session.getAttribute("userId");
        String upCodeAprvStatus = "B000";
        String upCodeSearchType = "C000";

        if ( userId != null) {
            boardList = boardService.getList(userId);
            aprvStatusList = boardService.getCode(upCodeAprvStatus);
            searchTypeList = boardService.getCode(upCodeSearchType);

            Map<String, List<Map<String, Object>>> listWithName = new HashMap<>();
            listWithName.put("boardList",boardList);
            listWithName.put("aprvStatusList",aprvStatusList);
            listWithName.put("searchTypeList",searchTypeList);

            resultList.add(listWithName);

        }

        return resultList;
    }
}
