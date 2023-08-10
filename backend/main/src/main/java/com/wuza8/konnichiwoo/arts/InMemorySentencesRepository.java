package com.wuza8.konnichiwoo.arts;

import org.hibernate.cfg.NotYetImplementedException;

import java.util.List;
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

    @Override
    public List<SentenceEntity> findAll(){
        throw new NotYetImplementedException();
    }

    @Override
    public SentenceEntity update(SentenceEntity entity) {
        throw new NotYetImplementedException();
    }
}
