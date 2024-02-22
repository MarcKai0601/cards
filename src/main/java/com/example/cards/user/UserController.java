package com.example.cards.user;

import com.example.cards.user.UserModel;
import com.example.cards.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//import javax.validation.Valid;
import java.util.Objects;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String viewRegisterPage(Model model) {
        model.addAttribute("name", "註冊");
        model.addAttribute("user", new UserModel());
        return "register";
    }

    @PostMapping("/register")
    public String registerProcess(UserModel user) {
        userService.addUser(user);
        return "redirect:/";
    }
}