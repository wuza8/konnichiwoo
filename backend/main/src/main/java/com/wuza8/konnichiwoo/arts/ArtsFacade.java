package com.wuza8.konnichiwoo.arts;

import com.wuza8.konnichiwoo.arts.dto.*;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ArtsFacade {
    private ArtsService artsService;

    public Long addNewArt(ArtAddDto artAddDto) {
        return artsService.addNewArt(artAddDto);
    }

    public List<ArtPreviewDto> getArtPreviews(ArtQueryDto textQueryDto) {
        return artsService.getArtPreviews(textQueryDto);
    }

    public ArtDto getArt(Long artId){
        return artsService.getArt(artId).createDto();
    }

    public SentenceDto getSentence(Long id){
        return artsService.getSentence(id).createDto();
    }
}
