package com.wuza8.konnichiwoo.gameplay;

import com.wuza8.konnichiwoo.arts.ArtsFacade;
import com.wuza8.konnichiwoo.arts.dto.ArtDto;
import com.wuza8.konnichiwoo.arts.dto.ArtPartDto;
import com.wuza8.konnichiwoo.arts.dto.SentenceDto;
import com.wuza8.konnichiwoo.gameplay.dto.Gameplay;
import com.wuza8.konnichiwoo.gameplay.dto.GameplayRequest;
import com.wuza8.konnichiwoo.gameplay.dto.GameplayResult;
import com.wuza8.konnichiwoo.gameplay.dto.RepetitionPart;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
class GameplayService {

    private ArtsFacade artsFacade;
    private PlayerRepetitionRecordRepository playerRecords;

    public Gameplay getNewGame(String userId, GameplayRequest gameplayRequest) {
        List<RepetitionPart> toRepeat = new ArrayList<>();

        ArtDto art = artsFacade.getArt(gameplayRequest.getArtId());
        List<PlayerRepetitionRecord> playerKnowledge = playerRecords.getPlayerRecords(userId);

        List<Long> sentenceIds = new ArrayList<>();
        for(ArtPartDto artPart : art.getArtParts()){
            sentenceIds.addAll(artPart.sentences);
        }

        for(Long sentenceId : sentenceIds){
            if(toRepeat.size() >= gameplayRequest.getNumberOfToRepeat())
                break;

            PlayerRepetitionRecord playerWordRecord = null;

            for(PlayerRepetitionRecord record : playerKnowledge){
                if(record.getWordId() == sentenceId) {
                    playerWordRecord = record;
                    break;
                }
            }

            if(playerWordRecord == null){
                SentenceDto sentence = artsFacade.getSentence(sentenceId);
                toRepeat.add(RepetitionPart.builder()
                        .wordId(sentenceId)
                        .goodAnswers(sentence.getGoodForeignAnswers())
                        .goodWriteAnswers(sentence.getGoodEnglishAnswers())
                        .isNew(true)
                        .build());
            }
        }

        return Gameplay.builder().gameplayId(1L).toRepeat(toRepeat).build();
    }

    public void endRepetition(String userId, GameplayResult gameplayResult){

    }
}
