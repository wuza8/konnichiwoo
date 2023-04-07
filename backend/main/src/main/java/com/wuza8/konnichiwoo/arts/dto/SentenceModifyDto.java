package com.wuza8.konnichiwoo.arts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SentenceModifyDto {
    private Long languageId;
    private String sentenceWritings;
    private String memoPictureURL;
    private String translation;
    private String goodForeignAnswers;
    private String goodEnglishAnswers;
}