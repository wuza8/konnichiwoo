package com.wuza8.konnichiwoo.gameplay;

import com.wuza8.konnichiwoo.arts.ArtEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

interface MongoPlayerGameplayHistory extends MongoRepository<ArtHistoryEntity, String> {
    List<ArtHistoryEntity> findByPlayerId(String playerId);
}
