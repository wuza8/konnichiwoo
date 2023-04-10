package com.wuza8.konnichiwoo.arts.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class SentenceAddWithArtDto {
    private Long partTimeId;
    private String memoPictureURL;
    private String translation;
    private List<String> goodForeignAnswers;
    private List<String> goodEnglishAnswers;
}
