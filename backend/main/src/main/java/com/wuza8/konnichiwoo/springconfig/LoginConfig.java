package com.wuza8.konnichiwoo.springconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;

@Configuration
class LoginConfig {
    @Autowired
    @Getter
    @Value("${login.afterLoginRedirectUri}")
    private String afterLoginRedirectUri;

    @Autowired
    @Getter
    @Value("${login.afterLogoutRedirectUri}")
    private String afterLogoutRedirectUri;
}
