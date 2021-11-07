package cn.txy.service;

import cn.txy.dto.LoginRequest;
import cn.txy.dto.LoginResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient("user-service")
public interface FeignApiUser {

    @PostMapping("login")
    LoginResult login(@RequestBody LoginRequest loginRequest);

}
