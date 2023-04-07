package com.wuza8.konnichiwoo.language;

import org.springframework.context.annotation.Bean;

class LanguageConfig {

    @Bean
    public LanguageFacade languageFacade() {
        InMemoryLanguageRepository repository = new InMemoryLanguageRepository();
        repository.add(new LanguageEntity(1L, "Japanese"));
        repository.add(new LanguageEntity(2L, "German"));
        return new LanguageFacade(new LanguageService(new InMemoryLanguageRepository()));
    }

    public LanguageFacade languageFacadeTest() {
        InMemoryLanguageRepository repository = new InMemoryLanguageRepository();
        return new LanguageFacade(new LanguageService(new InMemoryLanguageRepository()));
    }
}
