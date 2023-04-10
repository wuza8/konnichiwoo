package com.wuza8.konnichiwoo.gameplay;

import com.wuza8.konnichiwoo.gameplay.dto.Gameplay;
import com.wuza8.konnichiwoo.gameplay.dto.GameplayRequest;
import com.wuza8.konnichiwoo.gameplay.dto.GameplayResult;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.*;

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
}
