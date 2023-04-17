package com.wuza8.konnichiwoo.arts;

import com.wuza8.konnichiwoo.arts.dto.SentenceDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Document("sentence")
@Builder
class SentenceEntity {
    @Id
    private String id;
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
