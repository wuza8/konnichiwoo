package com.wuza8.konnichiwoo.gameplay.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
public class Gameplay {
    private Long gameplayId;
    private List<RepetitionPart> toRepeat;
}
