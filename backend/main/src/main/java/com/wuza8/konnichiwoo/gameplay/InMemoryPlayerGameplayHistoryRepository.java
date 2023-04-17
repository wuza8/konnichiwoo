package com.wuza8.konnichiwoo.gameplay;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class InMemoryPlayerGameplayHistoryRepository implements PlayerGameplayHistoryRepository{
    private ConcurrentHashMap<String, Set<String>> history = new ConcurrentHashMap<>();

    public void addHistory(String userId, String artId){
        Set<String> hist = history.get(userId);

        if(hist == null){
            hist = new HashSet<>();
            history.put(userId, hist);
        }

        hist.add(artId);
    }

    public List<String> getLastPlayed(String userId){
        Set<String> hist = history.get(userId);

        if(hist == null){
            return new ArrayList<>();
        }
        else{
            return hist.stream().toList();
        }
    }
}
