package com.wuza8.konnichiwoo.arts;

interface SentencesRepository {
    String add(SentenceEntity sentenceEntity);
    SentenceEntity find(String id);

}
