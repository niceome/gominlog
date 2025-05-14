package com.gominlog.gominlog.controller;

import com.gominlog.gominlog.dto.UserJoinDto;
import com.gominlog.gominlog.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("/join")
    public String joinForm(Model model) {
        model.addAttribute("user", new UserJoinDto());
        return "user/join";
    }
    @PostMapping("/join")
    public String joinSubmit(@ModelAttribute("user") @Valid UserJoinDto userDto,
                             BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "join/join";
        }

        userService.join(userDto);
        return "redirect:/user/login";

    }

    @GetMapping("/login")
    public String loginForm() {
        return "user/login";
    }

}
