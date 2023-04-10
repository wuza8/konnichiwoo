package com.wuza8.konnichiwoo.gameplay;

import com.wuza8.konnichiwoo.arts.ArtsConfig;
import com.wuza8.konnichiwoo.arts.ArtsFacade;
import com.wuza8.konnichiwoo.gameplay.dto.Gameplay;
import com.wuza8.konnichiwoo.gameplay.dto.GameplayRequest;
import com.wuza8.konnichiwoo.utils.ArtMother;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameplayTest {
    private ArtsFacade artsFacade = new ArtsConfig().artsFacade();
    private GameplayFacade gameplayFacade = new GameplayConfig().gameplayFacade(artsFacade);

    @Test
    public void createNewGameTest(){
        artsFacade.addNewArt(ArtMother.validArtToAdd);

        Gameplay gameplay = gameplayFacade.getNewGame("bob", GameplayRequest.builder()
                .artId(1L).numberOfToRepeat(10L).build());

        Assertions.assertEquals(1, gameplay.getToRepeat().size());
    }
}
