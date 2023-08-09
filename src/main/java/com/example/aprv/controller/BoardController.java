package com.example.aprv.controller;

import com.example.aprv.service.BoardService;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
    public List<Map<String,Object>> getList(HttpSession session) {
        List<Map<String,Object>> resultList = new ArrayList<>();
        String userId = (String) session.getAttribute("userId");

        // session에 값이 없을때 어떻게 찍히는지?
        // null?

        if ( userId != null) {
            resultList = boardService.getList(userId);
//            resultList = boardService.getList();
        }

        return resultList;
    }
}
