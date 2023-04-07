package com.wuza8.konnichiwoo.arts.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class SentenceAddDto {
    private Long languageId;
    private String memoPictureURL;
    private String translation;
    private String goodForeignAnswers;
    private String goodEnglishAnswers;
}
