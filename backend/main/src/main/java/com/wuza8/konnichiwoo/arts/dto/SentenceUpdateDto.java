package com.wuza8.konnichiwoo.arts.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SentenceUpdateDto {
    private String id;
    private List<String> goodForeignAnswers;
    private List<String> goodEnglishAnswers;
    private String memoPictureURL;
}
