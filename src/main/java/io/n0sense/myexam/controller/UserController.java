package io.n0sense.myexam.controller;

import io.n0sense.myexam.service.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLoginView() {
        return "login";
    }

    @PostMapping("/login")
    public String attemptLogin(String username, String password, Model model) {
        if (userService.checkLogin(username, password)) {
            return "redirect:list";
        } else {
            model.addAttribute("msg", "用户名或密码不正确。");
            return "login";
        }
    }
}
