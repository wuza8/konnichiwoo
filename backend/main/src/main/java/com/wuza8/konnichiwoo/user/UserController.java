package com.wuza8.konnichiwoo.user;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    
    @GetMapping("current")
    @ResponseBody
    public UserDTO getLogged(OAuth2AuthenticationToken principal){
        if(principal == null)
            return null;
        else
            return new UserDTO(principal.getName());
    }
}
