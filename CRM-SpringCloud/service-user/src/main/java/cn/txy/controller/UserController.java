package cn.txy.controller;

import cn.txy.dto.LoginRequest;
import cn.txy.dto.LoginResult;
import cn.txy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("login")
    public LoginResult login(@RequestBody LoginRequest loginRequest) {
        return service.login(loginRequest.getUsercode(), loginRequest.getPassword());
    }

}
