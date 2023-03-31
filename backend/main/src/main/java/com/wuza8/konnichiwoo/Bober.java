package com.wuza8.konnichiwoo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@RestController
@RequestMapping("/bobi")
public class Bober {

    @GetMapping("login")
    public String bober (Principal principal) {
        // attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectView");
        // attributes.addAttribute("attribute", "redirectWithRedirectView");
        // return new RedirectView("http://localhost:8000/src/index.html");
        return principal.hasRole();
    }
}
