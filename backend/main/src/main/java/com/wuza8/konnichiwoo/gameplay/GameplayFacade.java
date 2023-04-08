package com.wuza8.konnichiwoo.gameplay;

import com.wuza8.konnichiwoo.gameplay.dto.Gameplay;
import com.wuza8.konnichiwoo.gameplay.dto.GameplayRequest;
import com.wuza8.konnichiwoo.gameplay.dto.GameplayResult;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GameplayFacade {

    private GameplayService gameplayService;

    public Gameplay getNewGame(String userId, GameplayRequest gameplayRequest) {
        return null;
    }

    public void recordGame(GameplayResult gameplayResult) {

    }
}
