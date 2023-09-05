package com.example.aprv.controller;

import com.example.aprv.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public Map<String,Object> getLogin(@RequestParam String id, @RequestParam String pass, HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<>();

        resultMap = userService.getLogin(id);

        if( resultMap != null && resultMap.get("usr_pass").equals(pass)) {
            resultMap.put("msg","success");
            HttpSession session = request.getSession();

            System.out.println("this is resultMap" + resultMap);

            session.setAttribute("userId", id);
            session.setAttribute("position", resultMap.get("usr_position"));
            session.setMaxInactiveInterval(60 * 30);
        } else {
            resultMap.put("msg","fail");
        }

        return resultMap;
    }

    @GetMapping("/logout")
    public void logout(HttpSession session) {
        session.invalidate();
    }

}
