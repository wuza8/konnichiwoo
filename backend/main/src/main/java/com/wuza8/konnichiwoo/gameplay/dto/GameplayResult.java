package com.wuza8.konnichiwoo.gameplay.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GameplayResult {
    private Long gameplayId;
    private List<RepetitionPartResult> result;
}
