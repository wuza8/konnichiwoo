package com.wuza8.konnichiwoo.gameplay.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GameplayRequest {
    private String artId;
    private Long numberOfToRepeat;
}
