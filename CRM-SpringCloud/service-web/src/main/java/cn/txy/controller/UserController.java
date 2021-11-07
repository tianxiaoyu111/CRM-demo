package cn.txy.controller;

import cn.txy.dto.LoginRequest;
import cn.txy.dto.LoginResult;
import cn.txy.pojo.CrmUser;
import cn.txy.service.FeignApiUser;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private FeignApiUser feignApiUser;

    @RequestMapping("/showlogin")
    public String showLogin() {
        return "login";
    }

    @RequestMapping("/dologin")
    public String doLogin(String usercode, String password, HttpSession session, Model model) {
        LoginResult result = feignApiUser.login(new LoginRequest(usercode, password));

        if (result.getUser() == null) {
            model.addAttribute("msg", result.getMsg());
            return "forward:/showlogin";
        } else {
            session.setAttribute("user", result.getUser());
            return "redirect:/customerList";
        }

    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        CrmUser user = (CrmUser) session.getAttribute("user");
        session.removeAttribute("user");
        LoggerFactory.getLogger(getClass()).info(user.getUserName() + "退出了系统..");
        return "redirect:/showlogin";
    }
}
