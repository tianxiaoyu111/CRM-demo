package cn.txy.controller;

import cn.txy.dto.LoginResult;
import cn.txy.pojo.CrmUser;
import cn.txy.service.UserService;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private Logger logger;

    @RequestMapping("/showlogin")
    public String showLogin() {
        return "login";
    }

    @RequestMapping("/dologin")
    public String doLogin(String usercode, String password, HttpSession session, Model model) {
        LoginResult result = userService.login(usercode, password);

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
        logger.info(user.getUserName() + "退出了系统..");
        return "redirect:/showlogin";
    }
}
