package com.example.task1.controller;

import com.example.task1.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/")
public class HomeController {

    private static final List<User> users = List.of(
            new User(1L, "Ngô Văn Sơn", "son100260@donga.edu.vn", "Thành viên backend của nhóm 5."),
            new User(2L, "Nguyễn Xuân Thành", "thanh9918@donga.edu.vn", "Thành viên frontend của nhóm 5."));

    @GetMapping("/")
    public String getHomePage(Model model) {
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping("/user")
    public String getUserDetail(@RequestParam Long id, Model model) {
        Optional<User> userOpt = users.stream().filter(u -> u.getId().equals(id)).findFirst();
        if (userOpt.isEmpty()) {
            return "redirect:/"; // Hoặc trang lỗi
        }
        model.addAttribute("user", userOpt.get());
        return "user-detail";
    }
}
