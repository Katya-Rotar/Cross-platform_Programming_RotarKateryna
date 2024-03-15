package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public String index(Model model) {
        model.addAttribute("pageTitle", "Hello JVM world!");
        model.addAttribute("languages", List.of("Java", "Kotlin", "Groovy", "Clojure"));
        model.addAttribute("title", "users.title");
        return "index";
    }
}