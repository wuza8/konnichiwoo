package com.wuza8.konnichiwoo.gameplay.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class RepetitionPart {
    private String wordId;
    private List<String> goodAnswers;
    private List<String> goodWriteAnswers;
    private Boolean isNew;
    private String memoPictureURL;
}
