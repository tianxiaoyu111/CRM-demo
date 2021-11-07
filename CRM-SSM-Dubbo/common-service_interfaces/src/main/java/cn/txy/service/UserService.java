package cn.txy.service;

import cn.txy.dto.LoginResult;

public interface  UserService {

    LoginResult login(String usercode, String password);
}
