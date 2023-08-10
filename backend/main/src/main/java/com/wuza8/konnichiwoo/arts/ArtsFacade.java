package com.wuza8.konnichiwoo.arts;

import com.wuza8.konnichiwoo.arts.dto.*;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class ArtsFacade {
    private ArtsService artsService;

    public String addNewArt(ArtAddDto artAddDto) {
        return artsService.addNewArt(artAddDto);
    }

    public List<ArtEntity> searchArts(ArtQueryDto textQueryDto) {
        return artsService.searchArts(textQueryDto);
    }

    public ArtDto getArt(String artId){
        return artsService.getArt(artId).createDto();
    }

    public SentenceDto getSentence(String id){
        return artsService.getSentence(id).createDto();
    }

    public List<SentenceDto> getAllSentences(){
        List<SentenceDto> dtos = new ArrayList<>();

        for(SentenceEntity sentence : artsService.getAllSentences()){
            dtos.add(sentence.createDto());
        }

        return dtos;
    }

    public void updateSentence(SentenceUpdateDto updateDto) {
        artsService.updateSentence(updateDto.getId(),
                updateDto.getGoodEnglishAnswers(),
                updateDto.getGoodForeignAnswers(),
                updateDto.getMemoPictureURL());
    }
}
