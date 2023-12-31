package com.example.aprv.controller;

import com.example.aprv.service.BoardService;
import com.example.aprv.service.ReprService;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/repr")
public class ReprController {

    private final ReprService reprService;

    public ReprController(ReprService reprService) {
        this.reprService = reprService;
    }

    @GetMapping("/list")
    public List<Map<String,Object>> getList(HttpSession session) {

        List<Map<String,Object>> positionList = new ArrayList<>();

        String position = (String) session.getAttribute("position");

        if ( position != null || position.equals("A003") || position.equals("A004") || position.equals("A005") ) {
            positionList = reprService.getPosition(position);
        }

        return positionList;

    }

    @GetMapping("/user")
    public List<Map<String,Object>> getUserList(HttpSession httpSession, @RequestParam String position) {

        List<Map<String,Object>> userList = new ArrayList<>();

       if (position != null) {
           userList = reprService.getUser(position);
       }

       return userList;
    }

    @GetMapping("/board")
    public List<Map<String,Object>> getBoardList(HttpSession httpSession) {

        List<Map<String,Object>> boardList = new ArrayList<>();
        boardList = reprService.getBoard();

        return boardList;
    }


//    @GetMapping("list")
//    public List<Map<String, List<Map<String, Object>>>> getList(HttpSession session) {
//        List<Map<String, List<Map<String, Object>>>> resultList = new ArrayList<>();
//
//        List<Map<String,Object>> positionList = new ArrayList<>();
//        List<Map<String,Object>> personList = new ArrayList<>();
//
//        String position = (String) session.getAttribute("position");
//
//        // 기로그인 user의 position 있음.
//        if ( position != null || position.equals("A003") || position.equals("A004") || position.equals("A005") ) {
//            Map<String, List<Map<String, Object>>> listWithName = new HashMap<>();
//
//            positionList = reprService.getPosition(position);
//
//            listWithName.put("positionList", positionList);
//            listWithName.put("personList", personList);
//
//            resultList.add(listWithName);
//        }
//
//        return resultList;
//    }


}
