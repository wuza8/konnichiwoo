package com.wuza8.konnichiwoo.arts;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArtsConfig {
    @Bean
    public ArtsFacade artsFacade(){
        return new ArtsFacade(new ArtsService(new InMemoryArtsRepository(), new InMemorySentencesRepository()));
    }
}
