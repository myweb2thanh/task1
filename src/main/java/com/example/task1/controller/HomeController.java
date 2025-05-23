package com.example.task1.controller;

import com.example.task1.model.MemberInfo;
import com.example.task1.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/")
    public String getHomePage(@RequestParam(required = false) String name, Model model) {
        if (name == null || name.isBlank()) {
            return "index";
        }

        MemberInfo member = memberService.getMemberByName(name);
        if (member != null) {
            model.addAttribute("fullName", member.getFullName());
            model.addAttribute("age", member.getAge());
            model.addAttribute("school", member.getSchool());
            model.addAttribute("birthYear", member.getBirthYear());
        } else {
            model.addAttribute("fullName", "Không tìm thấy");
            model.addAttribute("age", "-");
            model.addAttribute("school", "-");
            model.addAttribute("birthYear", "-");
        }

        return "detail";
    }
}
