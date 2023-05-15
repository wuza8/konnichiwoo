package com.wuza8.konnichiwoo.gameplay;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
class MongoAdapterPlayerGameplayHistoryRepository implements PlayerGameplayHistoryRepository{
    private MongoPlayerGameplayHistory repo;

    @Override
    public void addHistory(String userId, String artId) {
        List<ArtHistoryEntity> entities = repo.findByPlayerId(userId);
        ArtHistoryEntity entity = null;

        if(entities.size() != 0){
            entity = entities.get(0);
        }

        if(entity == null){
            entity = new ArtHistoryEntity(userId, new ArrayList<>());
        }

        for(String id : entity.getArtIds()){
            if(id == artId) return;
        }

        entity.getArtIds().add(artId);
        repo.save(entity);
    }

    @Override
    public ArtHistoryEntity getLastPlayed(String userId) {
        List<ArtHistoryEntity> entities = repo.findByPlayerId(userId);
        if(entities.size() == 0) return null;
        return entities.get(0);
    }
}
