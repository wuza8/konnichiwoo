package com.wuza8.konnichiwoo.arts.dto;

import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class SentenceDto {
    private String id;
    private long languageId;
    private String translation;
    private String memoPictureURL;
    private List<String> goodForeignAnswers;
    private List<String> goodEnglishAnswers;
}
