package com.wuza8.konnichiwoo.arts;

import com.wuza8.konnichiwoo.arts.dto.ArtPreviewDto;
import com.wuza8.konnichiwoo.arts.dto.ArtQueryDto;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class InMemoryArtsRepository implements ArtsRepository{

    private ConcurrentHashMap<Long, ArtEntity> arts = new ConcurrentHashMap<>();
    private Long nextId = 1L;

    public Long add(ArtEntity artEntity){
        artEntity.setId(nextId);
        arts.put(nextId, artEntity);
        nextId++;
        return artEntity.getId();
    }

    public ArtEntity find(Long artId){
        return arts.get(artId);
    }

    public List<ArtPreviewDto> findPreviews(ArtQueryDto query){
        List<ArtEntity> found = new ArrayList<>();

        for(ArtEntity art : arts.values()){
            if(art.getTextName().contains(query.getName())){
                found.add(art);
            }
        }

        List<ArtPreviewDto> previews = new ArrayList<>();

        for(ArtEntity art : found){
            previews.add(new ArtPreviewDto(art.getTextName()));
        }

        return previews;
    }

}
