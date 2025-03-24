package ru.netology.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.security.RolesAllowed;

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

    @GetMapping("/admin")
    @PostAuthorize("hasRole('READ' and hasRole('WRITE' and hasRole('DELETE')))")
    public String getAdmins() {
        return "admins.html";
    }

    @GetMapping("/read")
    @Secured("ROLE_READ")
    public String getReader() {
        return "Hello, reader!";
    }

    @GetMapping("/write")
    @RolesAllowed("ROLE_WRITE")
    public String getWriter() {
        return "Hello, writer!";
    }

    @GetMapping("/corrector")
    @PreAuthorize("hasAnyRole('DELETE', 'WRITE')")
    public String getCorrector() {
        return "Hello, corrector!";
    }

    @GetMapping("/user")
    @PreAuthorize("#username == authentication.principal.username")
    public String getUserInfo(@RequestParam String username) {
        return "Hello, " + username + "!";
    }
}
