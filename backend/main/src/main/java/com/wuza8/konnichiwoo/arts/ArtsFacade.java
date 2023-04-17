package com.wuza8.konnichiwoo.arts;

import com.wuza8.konnichiwoo.arts.dto.*;
import lombok.AllArgsConstructor;

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
}
