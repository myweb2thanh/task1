package com.example.task1.controller;




import com.example.task1.entity.User;
import com.example.task1.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Hiển thị danh sách users
    @GetMapping
    public String listUsers(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "users/list";
    }

    // Hiển thị form thêm user mới
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("user", new User());
        return "users/form";
    }

    // Xử lý thêm user mới
    @PostMapping("/save")
    public String saveUser(@Valid @ModelAttribute("user") User user,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes,
                           Model model) {

        // Kiểm tra validation errors
        if (bindingResult.hasErrors()) {
            return "users/form";
        }

        // Kiểm tra email đã tồn tại chưa
        if (userRepository.existsByEmail(user.getEmail())) {
            bindingResult.rejectValue("email", "error.user", "Email đã tồn tại trong hệ thống");
            return "users/form";
        }

        try {
            userRepository.save(user);
            redirectAttributes.addFlashAttribute("successMessage", "Thêm người dùng thành công!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Có lỗi xảy ra khi thêm người dùng: " + e.getMessage());
        }

        return "redirect:/users";
    }

    // Hiển thị form chỉnh sửa user
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Không tìm thấy người dùng!");
            return "redirect:/users";
        }
        model.addAttribute("user", user);
        return "users/form";
    }

    // Xử lý cập nhật user
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable Long id,
                             @Valid @ModelAttribute("user") User user,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "users/form";
        }

        // Kiểm tra email đã tồn tại cho user khác chưa
        User existingUserWithEmail = userRepository.findByEmail(user.getEmail()).orElse(null);
        if (existingUserWithEmail != null && !existingUserWithEmail.getId().equals(id)) {
            bindingResult.rejectValue("email", "error.user", "Email đã tồn tại trong hệ thống");
            return "users/form";
        }

        try {
            user.setId(id);
            userRepository.save(user);
            redirectAttributes.addFlashAttribute("successMessage", "Cập nhật người dùng thành công!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Có lỗi xảy ra khi cập nhật người dùng: " + e.getMessage());
        }

        return "redirect:/users";
    }

    // Xóa user
    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            if (userRepository.existsById(id)) {
                userRepository.deleteById(id);
                redirectAttributes.addFlashAttribute("successMessage", "Xóa người dùng thành công!");
            } else {
                redirectAttributes.addFlashAttribute("errorMessage", "Không tìm thấy người dùng!");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Có lỗi xảy ra khi xóa người dùng: " + e.getMessage());
        }

        return "redirect:/users";
    }

    // Trang chủ redirect về danh sách users
    @GetMapping("/")
    public String home() {
        return "redirect:/users";
    }
}