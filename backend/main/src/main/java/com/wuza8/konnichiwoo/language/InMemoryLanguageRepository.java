package com.wuza8.konnichiwoo.language;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class InMemoryLanguageRepository implements LanguageRepository{
    private Long nextId = 1L;
    private ConcurrentHashMap<Long, LanguageEntity> languages = new ConcurrentHashMap<>();

    public void add(LanguageEntity languageEntity){
        languageEntity.setId(nextId);
        languages.put(nextId, languageEntity);
        nextId++;
    }

    public void remove(Long id){
        languages.remove(id);
    }

    public List<LanguageEntity> findAll(){
        return languages.values().stream().toList();
    }
}
