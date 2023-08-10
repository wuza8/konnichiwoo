package com.wuza8.konnichiwoo.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class UserDTO {
    private String username;
    private List<String> roles;
}
