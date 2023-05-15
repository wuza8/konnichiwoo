package com.wuza8.konnichiwoo.gameplay;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Document("repetitionRecord")
class PlayerRepetitionRecord {
    @Id
    private String repetitionRecordId;
    private String userId;
    private String wordId;
    private int relativeKnowledge;
    private LocalDateTime lastLearning;
}
