package com.wuza8.konnichiwoo.gameplay;

import com.wuza8.konnichiwoo.arts.ArtEntity;
import com.wuza8.konnichiwoo.arts.ArtsFacade;
import com.wuza8.konnichiwoo.arts.dto.*;
import com.wuza8.konnichiwoo.gameplay.dto.*;
import lombok.AllArgsConstructor;
import org.springframework.security.core.parameters.P;

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
                if(record.getWordId().equals(sentenceId)) {
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
        List<PlayerRepetitionRecord> records = playerRecords.getPlayerRecords(userId);

        for(RepetitionPartResult result : gameplayResult.getResult()) {
            PlayerRepetitionRecord record = null;
            for (PlayerRepetitionRecord rec : records) {
                if (rec.getWordId().equals(result.getWordId())) {
                    record = rec;
                    break;
                }
            }

            if (record == null) {
                record = new PlayerRepetitionRecord();
            }

            record.setUserId(userId);
            record.setWordId(result.getWordId());
            record.setRelativeKnowledge(record.getRelativeKnowledge() + result.getFailedTimes());
            playerRecords.addPlayerRecord(record);
        }
    }

    public List<ArtPreviewDto> searchForArt(String userId, ArtQueryDto query){
        List<ArtPreviewDto> artPreviews = new ArrayList<>();
        List<ArtEntity> arts = artsFacade.searchArts(query);
        List<PlayerRepetitionRecord> records = playerRecords.getPlayerRecords(userId);

        for(ArtEntity art : arts){
            ArtPreviewDto preview = new ArtPreviewDto();
            preview.setId(art.getId());
            preview.setName(art.getTextName());
            preview.setThumbs(69L);
            preview.setProgress(calculateProgress(art.getArtParts().get(0).getSentences(), records));
            artPreviews.add(preview);
        }

        return artPreviews;
    }

    public List<ArtPreviewDto> getGameplayHistory(String userId) {
        ArtHistoryEntity gameplayHistory = playerGameplayHistory.getLastPlayed(userId);
        if(gameplayHistory == null) return null;
        List<PlayerRepetitionRecord> records = playerRecords.getPlayerRecords(userId);
        List<ArtPreviewDto> artPreviews = new ArrayList<>();

        for(String id : gameplayHistory.getArtIds()){
            ArtDto art = artsFacade.getArt(id);

            ArtPreviewDto preview = new ArtPreviewDto();
            preview.setId(art.getId());
            preview.setName(art.getTextName());
            preview.setThumbs(69L);
            preview.setProgress(calculateProgress(art.getArtParts().get(0).sentences, records));
            artPreviews.add(preview);
        }

        return artPreviews;
    }

    private Long calculateProgress(List<String> sentences, List<PlayerRepetitionRecord> records){
        Long points = 0L;

        for(String sentence : sentences){
            PlayerRepetitionRecord rec = null;
            for(PlayerRepetitionRecord record : records){
                if(record.getWordId().equals(sentence)){
                    rec = record;
                    break;
                }
            }
            if(rec != null) points++;
        }

        return (long) (((float)points/ (float) sentences.size()) * 100.0);
    }
}
