package com.wuza8.konnichiwoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.security.Principal;

@RestController
@RequestMapping("/api")
public class Endpoints {

    @Autowired
    LogoutHandler logouter;

    @GetMapping("login")
    public String bober (Principal principal) {
        // attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectView");
        // attributes.addAttribute("attribute", "redirectWithRedirectView");
        // return new RedirectView("http://localhost:8000/src/index.html");
        return principal.toString();
    }

    @GetMapping("logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, Authentication auth){
        logouter.logout(request,response,auth);
        return "bOB";
    }
}
