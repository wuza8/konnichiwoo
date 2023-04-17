package com.wuza8.konnichiwoo.gameplay;

import com.wuza8.konnichiwoo.arts.ArtEntity;
import com.wuza8.konnichiwoo.arts.ArtsFacade;
import com.wuza8.konnichiwoo.arts.dto.*;
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
    private PlayerGameplayHistoryRepository playerGameplayHistory;

    public Gameplay getNewGame(String userId, GameplayRequest gameplayRequest) {
        List<RepetitionPart> toRepeat = new ArrayList<>();

        playerGameplayHistory.addHistory(userId, gameplayRequest.getArtId());

        ArtDto art = artsFacade.getArt(gameplayRequest.getArtId());
        List<PlayerRepetitionRecord> playerKnowledge = playerRecords.getPlayerRecords(userId);

        List<String> sentenceIds = new ArrayList<>();
        for(ArtPartDto artPart : art.getArtParts()){
            sentenceIds.addAll(artPart.sentences);
        }

        for(String sentenceId : sentenceIds){
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

    public List<ArtPreviewDto> searchForArt(String userId, ArtQueryDto query){
        List<ArtPreviewDto> artPreviews = new ArrayList<>();
        List<ArtEntity> arts = artsFacade.searchArts(query);

        for(ArtEntity art : arts){
            ArtPreviewDto preview = new ArtPreviewDto();
            preview.setId(art.getId());
            preview.setName(art.getTextName());
            preview.setThumbs(69L);
            preview.setProgress(40L);
            artPreviews.add(preview);
        }

        return artPreviews;
    }

    public List<ArtPreviewDto> getGameplayHistory(String userId) {
        List<String> gameplayHistory = playerGameplayHistory.getLastPlayed(userId);
        List<ArtPreviewDto> artPreviews = new ArrayList<>();

        for(String l : gameplayHistory){
            ArtDto art = artsFacade.getArt(l);

            ArtPreviewDto preview = new ArtPreviewDto();
            preview.setId(art.getId());
            preview.setName(art.getTextName());
            preview.setThumbs(69L);
            preview.setProgress(40L);
            artPreviews.add(preview);
        }

        return artPreviews;
    }
}
