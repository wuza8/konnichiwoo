package com.wuza8.konnichiwoo.gameplay;

import com.wuza8.konnichiwoo.arts.dto.ArtPreviewDto;
import com.wuza8.konnichiwoo.arts.dto.ArtQueryDto;
import com.wuza8.konnichiwoo.gameplay.dto.Gameplay;
import com.wuza8.konnichiwoo.gameplay.dto.GameplayRequest;
import com.wuza8.konnichiwoo.gameplay.dto.GameplayResult;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class GameplayFacade {

    private GameplayService gameplayService;

    public Gameplay getNewGame(String userId, GameplayRequest gameplayRequest) {
        return gameplayService.getNewGame(userId, gameplayRequest);
    }

    public void endRepetition(String userId, GameplayResult gameplayResult){
        gameplayService.endRepetition(userId, gameplayResult);
    }

    public List<ArtPreviewDto> searchForArt(String userId, ArtQueryDto query){
        return gameplayService.searchForArt(userId, query);
    }

    public List<ArtPreviewDto> getGameplayHistory(String userId) {
        return gameplayService.getGameplayHistory(userId);
    }
}
