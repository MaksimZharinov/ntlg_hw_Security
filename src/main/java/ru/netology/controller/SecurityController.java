package ru.netology.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    @GetMapping("/public")
    public String getPublic() {
        return "public.html";
    }

    @GetMapping("/auth")
    public String getAuth() {
        return "auth.html";
    }

    @GetMapping("/admins")
    public String getAdmins() {
        return "admins.html";
    }
}
