package com.wuza8.konnichiwoo.arts;

import com.wuza8.konnichiwoo.arts.dto.SentenceDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
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

    public SentenceDto createDto(){
        return SentenceDto.builder()
                .id(id)
                .languageId(languageId)
                .translation(translation)
                .memoPictureURL(memoPictureURL)
                .goodForeignAnswers(new ArrayList<>(goodForeignAnswers))
                .goodEnglishAnswers(new ArrayList<>(goodEnglishAnswers))
                .build();
    }
}
