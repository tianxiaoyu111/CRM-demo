package cn.txy.intercept;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginStatusIntercept implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //如果没有登录就跳转到login页面,

        //已经登录则直接放行
        if (request.getSession().getAttribute("user") != null){
            return true;
        }
        // 或者 请求的是登录页面或接口 也放行
        if (request.getRequestURL().toString().contains("login")){
            return true;
        }
        //将用户发送至登录页面
        response.sendRedirect(request.getContextPath() + "/showlogin");
        return false;
    }
}
