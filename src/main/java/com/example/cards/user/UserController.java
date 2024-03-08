package com.example.cards.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
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
    public String registerProcess(@Valid UserModel user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            String message = Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage();
            redirectAttributes.addFlashAttribute("error", message);
            return "redirect:/register";
        }
        try {
            userService.addUser(user);
            return "redirect:/";
        } catch (IllegalArgumentException e) {
            // 捕獲重複註冊的異常，並將對應的錯誤訊息添加到模型中
            String errorMessage = e.getMessage(); // 錯誤訊息已經在 UserService.addUser 方法中設置
            redirectAttributes.addFlashAttribute("error", errorMessage);
            return "redirect:/register";
        }
    }
}