package com.wuza8.konnichiwoo.gameplay;

import com.wuza8.konnichiwoo.arts.ArtsConfig;
import com.wuza8.konnichiwoo.arts.ArtsFacade;
import com.wuza8.konnichiwoo.arts.dto.ArtAddDto;
import com.wuza8.konnichiwoo.arts.dto.ArtPartAddDto;
import com.wuza8.konnichiwoo.arts.dto.SentenceAddWithArtDto;
import com.wuza8.konnichiwoo.arts.enums.ArtType;
import com.wuza8.konnichiwoo.gameplay.dto.Gameplay;
import com.wuza8.konnichiwoo.gameplay.dto.GameplayRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class GameplayTest {
    private ArtsFacade artsFacade = new ArtsConfig().artsFacade();
    private GameplayFacade gameplayFacade = new GameplayConfig().gameplayFacade(artsFacade);

    @Test
    public void createNewGameTest(){
        ArtAddDto newArt = ArtAddDto.builder()
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
                        .translation("hello")
                        .goodEnglishAnswers(new ArrayList<>(List.of("hello")))
                        .goodForeignAnswers(new ArrayList<>(List.of("konnichiwa")))
                        .memoPictureURL(null)
                        .build())))
                .build();


        artsFacade.addNewArt(newArt);

        Gameplay gameplay = gameplayFacade.getNewGame("bob", GameplayRequest.builder()
                .artId(1L).numberOfToRepeat(10L).build());

        Assertions.assertEquals(1, gameplay.getToRepeat().size());
    }
}
