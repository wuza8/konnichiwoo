package com.wuza8.konnichiwoo.arts;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class MongoSentenceRepositoryFacade implements SentencesRepository{
    private MongoSentenceRepository repository;

    public String add(SentenceEntity sentenceEntity){
        return repository.save(sentenceEntity).getId();
    }
    public SentenceEntity find(String id){
        return repository.findById(id).orElse(null);
    }
}
