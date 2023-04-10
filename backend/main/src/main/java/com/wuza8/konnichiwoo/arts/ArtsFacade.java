package com.wuza8.konnichiwoo.arts;

import com.wuza8.konnichiwoo.arts.dto.*;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ArtsFacade {
    private ArtsService artsService;

    public void addNewSentence(SentenceAddDto sentenceAddDto) {

    }

    public void modifySentence(SentenceModifyDto sentenceModifyDto) {

    }

    public void removeSentence(Long sentenceId) {

    }

    public Long addNewArt(ArtAddDto artAddDto) {
        return artsService.addNewArt(artAddDto);
    }

    public void removeArt(ArtAddDto textAddDto) {

    }

    public List<ArtPreviewDto> getArtPreviews(ArtQueryDto textQueryDto) {
        return artsService.getArtPreviews(textQueryDto);
    }

    public ArtDto getArt(Long artId){
        return artsService.getArt(artId);
    }

    public SentenceDto getSentence(Long id){
        return artsService.getSentence(id);
    }
}
