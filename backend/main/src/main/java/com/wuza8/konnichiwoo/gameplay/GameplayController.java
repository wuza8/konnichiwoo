package com.wuza8.konnichiwoo.gameplay;

import com.wuza8.konnichiwoo.gameplay.dto.Gameplay;
import com.wuza8.konnichiwoo.gameplay.dto.GameplayRequest;
import com.wuza8.konnichiwoo.gameplay.dto.GameplayResult;
import com.wuza8.konnichiwoo.gameplay.dto.RepetitionPart;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/gameplay")
class GameplayController {

    private GameplayFacade gameplayFacade;

    @PostMapping("start")
    public ResponseEntity<Gameplay> startRepetition(OAuth2AuthenticationToken token, @RequestBody GameplayRequest gameplayRequest){
//        Gameplay gameplay = new Gameplay();
//        gameplay.setGameplayId(1L);
//        gameplay.setToRepeat(List.of(RepetitionPart.builder()
//                        .isNew(true)
//                        .goodAnswers(List.of("hello", token.getPrincipal().getAttribute("sub")))
//                        .goodWriteAnswers(List.of("konnichiwa"))
//                        .wordId(1L)
//                .build()));
//        return
        return new ResponseEntity<>(
                gameplayFacade.getNewGame(token.getPrincipal().getAttribute("sub"), gameplayRequest),
                HttpStatus.OK);
    }

//    @RequestMapping(value = "/omg", method = RequestMethod.POST)
//    public ResponseEntity<String> persistPerson(@RequestBody GameplayRequest person) {
//        ResponseEntity<String> bob = new ResponseEntity<String>("terrorist", HttpStatus.OK);
//
//        return bob;
//    }
}
