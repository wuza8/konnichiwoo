package com.wuza8.konnichiwoo.utils;

import com.wuza8.konnichiwoo.arts.dto.ArtAddDto;
import com.wuza8.konnichiwoo.arts.dto.ArtPartAddDto;
import com.wuza8.konnichiwoo.arts.dto.SentenceAddWithArtDto;
import com.wuza8.konnichiwoo.arts.enums.ArtType;

import java.util.ArrayList;
import java.util.List;

public class ArtMother {
    public static ArtAddDto validArtToAdd = ArtAddDto.builder()
            .languageId(1L)
            .textName("Bobi")
            .artUrl(null)
            .artType(ArtType.MUSIC)
            .originalAuthor(null)
            .artParts(new ArrayList<>(
                    List.of(ArtPartAddDto.builder()
                            .subtitle("All")
                            .sentences(new ArrayList<>())
                            .newUsedSentences(new ArrayList<>(List.of(1L)))
                            .build())
            ))
            .addedSentences(new ArrayList<>(List.of(SentenceAddWithArtDto.builder()
                    .partTimeId(1L)
                    .goodEnglishAnswers(new ArrayList<>(List.of("hello")))
                    .goodForeignAnswers(new ArrayList<>(List.of("konnichiwa")))
                    .memoPictureURL(null)
                    .build())))
            .build();
}
