package com.example.task1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping("/")
    public String getHomePage(@RequestParam(required = false) String param) {
        if (param == null || param.isBlank()) {
            param = "anonymous";
        }
        System.out.println("Param: " + param);
        return "index";
    }

}
