package com.wuza8.konnichiwoo.springconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.security.Principal;

@RestController
@RequestMapping("")
class LoginController {

    @Autowired
    private LoginConfig loginConfig;

    @Autowired
    private LogoutHandler logouter;

    @GetMapping("login")
    public RedirectView bober (Principal principal) {
        return new RedirectView(loginConfig.getAfterLoginRedirectUri());
    }

    @GetMapping("logout")
    public RedirectView logout(HttpServletRequest request, HttpServletResponse response, Authentication auth){
        logouter.logout(request,response,auth);
        return new RedirectView(loginConfig.getAfterLogoutRedirectUri());
    }
}
