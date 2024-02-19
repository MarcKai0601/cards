package com.example.springBootTest.Test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/register")
    public String viewRegisterPage(Model model) {
        model.addAttribute("name", "註冊");
        return "register";
    }
}