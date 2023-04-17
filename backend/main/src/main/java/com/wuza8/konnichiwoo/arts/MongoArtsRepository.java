package com.wuza8.konnichiwoo.arts;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

interface MongoArtsRepository extends MongoRepository<ArtEntity, String> {
    List<ArtEntity> findByTextNameLike(String name);
}
