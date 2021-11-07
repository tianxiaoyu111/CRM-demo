package cn.txy.dto;

import cn.txy.pojo.CrmUser;

/**
 * UserService的login方法返回结果的封装, 包括登录的user对象(如果成功登录的话)以及提示信息, 提供给前端使用.
 */
public class LoginResult {
    private CrmUser user;
    private String msg;

    @Override
    public String toString() {
        return "LoginResult{" +
                "user=" + user +
                ", msg='" + msg + '\'' +
                '}';
    }

    public CrmUser getUser() {
        return user;
    }

    public void setUser(CrmUser user) {
        this.user = user;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
