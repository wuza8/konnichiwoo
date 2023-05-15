package com.wuza8.konnichiwoo.gameplay;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

interface MongoPlayerRepetitionRecordRepository extends MongoRepository<PlayerRepetitionRecord, String> {
    List<PlayerRepetitionRecord> findByUserId(String userId);
}
