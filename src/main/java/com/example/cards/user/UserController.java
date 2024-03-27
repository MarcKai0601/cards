package com.example.cards.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Objects;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/register/view")
    public String viewRegisterPage(Model model) {
        model.addAttribute("name", "註冊");
        model.addAttribute("user", new UserModel());
        return "register";
    }

    @RequestMapping(value = "/register/add", method = {RequestMethod.GET, RequestMethod.POST})
    public String registerProcess(@Valid UserModel user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            String message = Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage();
            redirectAttributes.addFlashAttribute("error", message);
            return "register";
        }
        try {
            userService.addUser(user);
            return "redirect:/login";
        } catch (IllegalArgumentException e) {
            // 捕獲重複註冊的異常，並將對應的錯誤訊息添加到模型中
            String message = e.getMessage(); // 錯誤訊息已經在 UserService.addUser 方法中設置
            redirectAttributes.addFlashAttribute("error", message);
            return "register";
        }
    }


//    @GetMapping("/login")
//    public String ViewloginPage(Model model) {
//        model.addAttribute("name", "登入");
//        model.addAttribute("user", new UserModel());
//        return "register";
//    }
//
//    @PostMapping("/login")
//    public String loginProcess(@Valid UserModel user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
//        if (bindingResult.hasErrors()) {
//            String message = Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage();
//            redirectAttributes.addFlashAttribute("error", message);
//            return "redirect:/login";
//        }
//        try {
//            userService.addUser(user);
//            return "redirect:/";
//        } catch (IllegalArgumentException e) {
//            // 捕獲重複註冊的異常，並將對應的錯誤訊息添加到模型中
//            String message = e.getMessage(); // 錯誤訊息已經在 UserService.addUser 方法中設置
//            redirectAttributes.addFlashAttribute("error", message);
//            return "redirect:/login";
//        }
//    }
}