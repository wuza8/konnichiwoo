package com.wuza8.konnichiwoo.arts;

import org.springframework.data.mongodb.repository.MongoRepository;

interface MongoSentenceRepository extends MongoRepository<SentenceEntity, String> {
}
