package com.wuza8.konnichiwoo.arts.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class SentenceAddWithArtDto {
    private Long partTimeId;
    private String memoPictureURL;
    private String translation;
    private String goodForeignAnswers;
    private String goodEnglishAnswers;
}
