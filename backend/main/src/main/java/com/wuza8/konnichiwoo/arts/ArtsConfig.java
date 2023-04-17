package com.wuza8.konnichiwoo.arts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArtsConfig {
    @Autowired
    private MongoArtsRepository artsRepository;

    @Autowired
    private MongoSentenceRepository sentenceRepository;
    @Bean
    public ArtsFacade artsFacade(){
        return new ArtsFacade(new ArtsService(new MongoArtsRepositoryFacade(artsRepository)
                , new MongoSentenceRepositoryFacade(sentenceRepository)));
    }
}
