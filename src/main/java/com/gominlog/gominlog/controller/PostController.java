package com.gominlog.gominlog.controller;

import com.gominlog.gominlog.dto.PostDto;
import com.gominlog.gominlog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @GetMapping("/write")
    public String writeForm(Model model) {
        model.addAttribute("post", new PostDto());
        return "post/write";
    }
    @PostMapping("/write")
    public String writeSubmit(@ModelAttribute PostDto postDto) {
        postService.save(postDto);
        return "redirect:/post/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("posts", postService.findAll());
        return "post/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("post", postService.findById(id));
        return "post/detail";
    }

}

