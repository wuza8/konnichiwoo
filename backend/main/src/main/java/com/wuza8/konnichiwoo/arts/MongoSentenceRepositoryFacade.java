package com.wuza8.konnichiwoo.arts;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
class MongoSentenceRepositoryFacade implements SentencesRepository{
    private MongoSentenceRepository repository;

    public String add(SentenceEntity sentenceEntity){
        return repository.save(sentenceEntity).getId();
    }
    public SentenceEntity find(String id){
        return repository.findById(id).orElse(null);
    }

    public List<SentenceEntity> findAll(){
        return repository.findAll();
    }

    @Override
    public SentenceEntity update(SentenceEntity entity) {
        return repository.save(entity);
    }


}
