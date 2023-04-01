package com.wuza8.konnichiwoo;

import org.springframework.security.authorization.AuthorityAuthorizationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bobi")
public class Bober {

    @GetMapping("login")
    public String bober (OAuth2AuthenticationToken principal) {
        // attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectView");
        // attributes.addAttribute("attribute", "redirectWithRedirectView");
        // return new RedirectView("http://localhost:8000/src/index.html");
        return principal.toString();
    }

    @GetMapping("bobi")
    public String bobi(OAuth2AuthenticationToken principal, @RequestParam("role") String role){
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString() + "\n"+ AuthorityAuthorizationManager.hasRole(role);
    }
}
