package com.wuza8.konnichiwoo.gameplay;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class InMemoryPlayerGameplayHistoryRepository implements PlayerGameplayHistoryRepository{
    private ConcurrentHashMap<String, ArtHistoryEntity> history = new ConcurrentHashMap<>();

    public void addHistory(String userId, String artId){
        ArtHistoryEntity hist = history.get(userId);

        if(hist == null){
            hist = new ArtHistoryEntity(userId, new ArrayList<String>());
            history.put(userId, hist);
        }
        hist.getArtIds().add(artId);
        history.put(userId, hist);
    }

    public ArtHistoryEntity getLastPlayed(String userId){
//        Set<ArtHistoryEntity> hist = history.get(userId);
//
//        if(hist == null){
//            return new ArrayList<>();
//        }
//        else{
//            return hist.stream().toList();
//        }
        return null;
    }
}
