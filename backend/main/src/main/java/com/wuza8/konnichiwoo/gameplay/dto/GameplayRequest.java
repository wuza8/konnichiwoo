package com.wuza8.konnichiwoo.gameplay.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GameplayRequest {
    private Long artId;
    private Long numberOfToRepeat;
}
