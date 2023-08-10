package com.wuza8.konnichiwoo.arts;

import java.util.List;

interface SentencesRepository {
    String add(SentenceEntity sentenceEntity);
    SentenceEntity find(String id);

    List<SentenceEntity> findAll();
    SentenceEntity update(SentenceEntity entity);
}
