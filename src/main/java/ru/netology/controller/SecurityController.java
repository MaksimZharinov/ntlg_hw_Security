package ru.netology.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    @GetMapping("/public")
    public String getPublic() {
        return "redirect:/public.html";
    }

    @GetMapping("/auth")
    public String getAuth() {
        return "redirect:/auth.html";
    }

    @GetMapping("/admins")
    public String getAdmins() {
        return "redirect:/admins.html";
    }
}
