package com.wuza8.konnichiwoo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api")
public class Endpoints {

    @GetMapping("login")
    public String bobby(Principal principal){
        return "Hello "+principal.getName()+"!";
    }
}
