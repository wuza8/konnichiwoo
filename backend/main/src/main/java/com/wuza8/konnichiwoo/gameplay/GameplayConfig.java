package com.wuza8.konnichiwoo.gameplay;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class GameplayConfig {

    @Bean
    public GameplayFacade gameplayFacade(){
        return new GameplayFacade(new GameplayService());
    }
}
