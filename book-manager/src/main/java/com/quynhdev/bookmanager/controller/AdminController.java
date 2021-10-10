package com.quynhdev.bookmanager.controller;

import com.quynhdev.bookmanager.model.Admin;
import com.quynhdev.bookmanager.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping("/")
    public String display() {
        return "login";
    }

    @RequestMapping("/login")
    public String showLogin() {
        return "login";
    }

    @PostMapping("/home")
    public String checkLogin(ModelMap model, @RequestParam("username") String username,
                             @RequestParam("password") String password, HttpSession session) {
        if (adminService.checkLogin(username, password)) {
            System.out.println("Login thành công");
            session.setAttribute("USERNAME", username);

            Admin admin = adminService.findByUsername(username);
            session.setAttribute("AGE", adminService.calculateAge(admin));
            return "home";
        } else {
            System.out.println("Login thất bại");
            model.addAttribute("ERROR", "Username hoặc password không tồn tại!");
        }
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("USERNAME");
        session.removeAttribute("AGE");
        return "redirect:/login";
    }

    @GetMapping("goHome")
    public String goHome(HttpSession session) {
        if (session.getAttribute("USERNAME") != null) {
            return "home";
        } else {
            return "login";
        }
    }
}
