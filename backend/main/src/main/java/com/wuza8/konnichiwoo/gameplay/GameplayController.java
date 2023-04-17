package com.wuza8.konnichiwoo.gameplay;

import com.wuza8.konnichiwoo.arts.dto.ArtPreviewDto;
import com.wuza8.konnichiwoo.arts.dto.ArtQueryDto;
import com.wuza8.konnichiwoo.gameplay.dto.Gameplay;
import com.wuza8.konnichiwoo.gameplay.dto.GameplayRequest;
import com.wuza8.konnichiwoo.gameplay.dto.GameplayResult;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("gameplay")
class GameplayController {

    private GameplayFacade gameplayFacade;

    @PostMapping("start")
    public ResponseEntity<Gameplay> startRepetition(OAuth2AuthenticationToken token, @RequestBody GameplayRequest gameplayRequest){
        return new ResponseEntity<>(
                gameplayFacade.getNewGame(token.getPrincipal().getAttribute("sub"), gameplayRequest),
                HttpStatus.OK);
    }

    @PostMapping("end")
    public void endRepetition(OAuth2AuthenticationToken token, @RequestBody GameplayResult gameplayResult){
        gameplayFacade.endRepetition(token.getPrincipal().getAttribute("sub"), gameplayResult);
    }

    @GetMapping("history")
    public List<ArtPreviewDto> getHistory(OAuth2AuthenticationToken token){
        return gameplayFacade.getGameplayHistory(token.getPrincipal().getAttribute("sub"));
    }

    @PostMapping("search")
    public List<ArtPreviewDto> searchForArt(OAuth2AuthenticationToken token, @RequestBody ArtQueryDto query){
        return gameplayFacade.searchForArt(token.getPrincipal().getAttribute("sub"),query);
    }
}
