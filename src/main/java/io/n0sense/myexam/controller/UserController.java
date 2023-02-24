package io.n0sense.myexam.controller;

import io.n0sense.myexam.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    private final UserService userService;
    private final HttpSession session;

    public UserController(UserService userService, HttpSession session) {
        this.userService = userService;
        this.session = session;
    }

    @GetMapping("/login")
    public String getLoginView() {
        return "login";
    }

    @GetMapping("/register")
    public String getRegisterView() {
        return "regist";
    }

    @PostMapping("/login")
    public String attemptLogin(String username, String password, Model model) {
        if (userService.checkLogin(username, password)) {
            session.setAttribute("username", username);
            return "redirect:list";
        } else {
            model.addAttribute("msg", "用户名或密码不正确。");
            return "login";
        }
    }
}
