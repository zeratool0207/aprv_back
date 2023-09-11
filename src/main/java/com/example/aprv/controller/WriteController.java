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
        Map<String,Object> brdParamMap = new HashMap<>();
        Map<String,Object> hstParamMap = new HashMap<>();

        String userId = (String) session.getAttribute("userId");
        brdParamMap = (Map)param.get("param");
        brdParamMap.put("userId", userId);
        int boardResult = writeService.goBoardInsert(brdParamMap);

        String brd_id = brdParamMap.get("brd_id").toString();
//        hstParamMap.put("brd_id", brd_id);
//        hstParamMap.put("userId", userId);



        int historyResult = writeService.goHistoryInsert(brd_id);

    }


}
