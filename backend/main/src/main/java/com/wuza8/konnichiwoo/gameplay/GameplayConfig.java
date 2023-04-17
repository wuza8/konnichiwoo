package com.wuza8.konnichiwoo.gameplay;

import com.wuza8.konnichiwoo.arts.ArtsFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class GameplayConfig {

    @Bean
    public GameplayFacade gameplayFacade(ArtsFacade artsFacade){
        return new GameplayFacade(new GameplayService(artsFacade, new InMemoryPlayerRepetitionRecordRepositoryImpl(), new InMemoryPlayerGameplayHistoryRepository()));
    }
}
