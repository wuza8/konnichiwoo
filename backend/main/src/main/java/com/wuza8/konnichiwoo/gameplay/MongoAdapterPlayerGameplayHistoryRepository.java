package com.wuza8.konnichiwoo.gameplay;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

class MongoAdapterPlayerGameplayHistoryRepository implements PlayerGameplayHistoryRepository{
    private MongoPlayerGameplayHistory repo;

    public MongoAdapterPlayerGameplayHistoryRepository(MongoPlayerGameplayHistory repo){
        this.repo = repo;
    }

    @Override
    public void addHistory(String userId, String artId) {
        List<ArtHistoryEntity> entities = repo.findByPlayerId(userId);
        System.out.println("To add:");
        System.out.println(artId);
        ArtHistoryEntity entity = null;


        if(entities.size() != 0){
            entity = entities.get(0);
        }
        if(entity == null){
            entity = new ArtHistoryEntity(userId, new ArrayList<>());
        }
        System.out.println("Already added:");
        for(String ids : entity.getArtIds()){
            System.out.println(ids);
        }

        for(String id : entity.getArtIds()){
            if(id.equals(artId)) return;
        }

        System.out.println("its here");

        List<String> ids = new ArrayList<>(entity.getArtIds());
        ids.add(artId);
        entity.setArtIds(ids);
        repo.save(entity);
    }

    @Override
    public ArtHistoryEntity getLastPlayed(String userId) {
        List<ArtHistoryEntity> entities = repo.findByPlayerId(userId);
        if(entities.size() == 0) return null;
        return entities.get(0);
    }
}
