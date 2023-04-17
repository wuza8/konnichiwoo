package com.wuza8.konnichiwoo.arts;

import java.util.concurrent.ConcurrentHashMap;

class InMemorySentencesRepository implements SentencesRepository{
    private ConcurrentHashMap<String, SentenceEntity> sentences = new ConcurrentHashMap<>();
    private Long nextId = 1L;
    public String add(SentenceEntity sentenceEntity){
        sentenceEntity.setId(Long.toString(nextId));
        sentences.put(Long.toString(nextId), sentenceEntity);
        nextId++;
        return sentenceEntity.getId();
    }

    public SentenceEntity find(String id){
        return sentences.get(id);
    }
}
