package com.example.aprv.controller;

import com.example.aprv.service.UserService;
import com.example.aprv.service.WriteService;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/write")
public class WriteController {

    private final WriteService writeService;

    public WriteController(WriteService writeService) {
        this.writeService = writeService;
    }

    @GetMapping("/list")
    public List<Map<String, List<Map<String, Object>>>> getList(@RequestParam String brd_id, HttpSession session) {
        List<Map<String, List<Map<String, Object>>>> resultList = new ArrayList<>();

        List<Map<String,Object>> histList = new ArrayList<>();
        List<Map<String, Object>> boardList = new ArrayList<>();

        String userId = (String) session.getAttribute("userId");

        if (userId != null) {
            histList = writeService.getList(brd_id);
            boardList = writeService.getBoardView(brd_id);

            Map<String, List<Map<String, Object>>> listWithName = new HashMap<>();
            listWithName.put("histList",histList);
            listWithName.put("boardList",boardList);

            resultList.add(listWithName);
        }

        return resultList;
    }

    @GetMapping("/nextBrdId")
    public int goNextBrdId() {
        int brdId = writeService.goNextBrdId();

        return brdId;
    }

    @PutMapping
    public void goInsert(@RequestBody Map<String,Object> param, HttpSession session) {
//        System.out.println(param);

        String userId = (String) session.getAttribute("userId");
        param.put("userId", userId);

        int boardResult = writeService.goBoardInsert(param);

        System.out.println("boardResult," + boardResult);

    }


}
