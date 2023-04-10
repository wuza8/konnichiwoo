package com.wuza8.konnichiwoo.arts;

import com.wuza8.konnichiwoo.arts.dto.*;
import com.wuza8.konnichiwoo.arts.enums.ArtType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ArtsTest {
    private ArtsFacade artsFacade = new ArtsConfig().artsFacade();

    @Test
    public void addNewArt(){
        ArtAddDto newArt = ArtAddDto.builder()
                .languageId(1L)
                .textName("Bobi")
                .artUrl(null)
                .artType(ArtType.MUSIC)
                .originalAuthor(null)
                .artParts(new ArrayList<>(
                        List.of(ArtPartAddDto.builder()
                                .subtitle("All")
                                .sentences(new ArrayList<>(List.of(3L,5L,12L,7L)))
                                .newUsedSentences(new ArrayList<>(List.of(1L)))
                                .build())
                ))
                .addedSentences(new ArrayList<>(List.of(SentenceAddWithArtDto.builder()
                        .partTimeId(1L)
                        .translation("hello")
                        .goodEnglishAnswers(new ArrayList<>(List.of("hello")))
                        .goodForeignAnswers(new ArrayList<>(List.of("konnichiwa")))
                        .memoPictureURL(null)
                        .build())))
                .build();

        artsFacade.addNewArt(newArt);

        List<ArtPreviewDto> arts = artsFacade.getArtPreviews(new ArtQueryDto("Bobi"));

        Assertions.assertEquals(1, arts.size());
    }

}
