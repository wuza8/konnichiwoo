package com.wuza8.konnichiwoo.arts;

import com.wuza8.konnichiwoo.arts.dto.ArtQueryDto;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
class MongoArtsRepositoryFacade implements ArtsRepository{
    private MongoArtsRepository repository;

    public String add(ArtEntity artEntity){
        artEntity.setId(null);
        return repository.save(artEntity).getId();
    }
    public ArtEntity find(String artId){
        return repository.findById(artId).orElse(null);
    }
    public List<ArtEntity> findArts(ArtQueryDto query){
        return repository.findByTextNameLike(query.getName());
    }
}
