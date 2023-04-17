package com.wuza8.konnichiwoo.gameplay;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
class PlayerRepetitionRecord {
    private String userId;
    private String wordId;
    private Short relativeKnowledge;
    private LocalDateTime lastLearning;
}
