package com.wuza8.konnichiwoo.arts;

import java.util.concurrent.ConcurrentHashMap;

class InMemorySentencesRepository implements SentencesRepository{
    private ConcurrentHashMap<Long, SentenceEntity> sentences = new ConcurrentHashMap<>();
    private Long nextId = 1L;
    public Long add(SentenceEntity sentenceEntity){
        sentenceEntity.setId(nextId);
        sentences.put(nextId, sentenceEntity);
        nextId++;
        return sentenceEntity.getId();
    }

    public SentenceEntity find(Long id){
        return sentences.get(id);
    }
}
