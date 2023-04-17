package com.wuza8.konnichiwoo.arts;

import com.wuza8.konnichiwoo.arts.dto.ArtPreviewDto;
import com.wuza8.konnichiwoo.arts.dto.ArtQueryDto;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class InMemoryArtsRepository implements ArtsRepository{

    private ConcurrentHashMap<String, ArtEntity> arts = new ConcurrentHashMap<>();
    private Long nextId = 1L;

    public String add(ArtEntity artEntity){
        artEntity.setId(Long.toString(nextId));
        arts.put(Long.toString(nextId), artEntity);
        nextId++;
        return artEntity.getId();
    }

    public ArtEntity find(String artId){
        return arts.get(artId);
    }

    public List<ArtEntity> findArts(ArtQueryDto query){
        List<ArtEntity> found = new ArrayList<>();

        for(ArtEntity art : arts.values()){
            if(art.getTextName().contains(query.getName())){
                found.add(art);
            }
        }

        return found;
    }

}
