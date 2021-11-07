package cn.txy.dto;

import java.io.Serializable;

public class LoginRequest implements Serializable {
    private String usercode;
    private String password;

    @Override
    public String toString() {
        return "LoginRequest{" +
                "usercode='" + usercode + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginRequest(String usercode, String password) {

        this.usercode = usercode;
        this.password = password;
    }

    public LoginRequest() {

    }
}
