package com.wuza8.konnichiwoo.arts;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name="sentences")
@Builder
class SentenceEntity {
    @Id
    private Long id;
    private Long languageId;
    private String translation;
    private String memoPictureURL;
    private List<String> goodForeignAnswers;
    private List<String> goodEnglishAnswers;
}
