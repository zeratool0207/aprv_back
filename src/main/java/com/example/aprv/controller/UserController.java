package com.example.aprv.controller;

import com.example.aprv.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/user/login")
    public Map<String,Object> getLogin() {
        Map<String, Object> userMap = new HashMap<>();
        userMap = userService.getLogin();

        return userMap;
    }

}
