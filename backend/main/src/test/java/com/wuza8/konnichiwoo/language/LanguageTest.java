package com.wuza8.konnichiwoo.language;

import com.wuza8.konnichiwoo.language.dto.LanguageAddDto;
import com.wuza8.konnichiwoo.language.dto.LanguageDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class LanguageTest {

    private LanguageFacade languageFacade = new LanguageConfig().languageFacadeTest();

    @Test
    public void testAdding(){
        languageFacade.addLanguage(new LanguageAddDto("Bobby"));
        Assertions.assertEquals(1, languageFacade.getAllLanguages().size());
    }

    @Test
    public void testRemoving(){
        languageFacade.addLanguage(new LanguageAddDto("Bobby"));

        List<LanguageDto> languages = languageFacade.getAllLanguages();
        languageFacade.removeLanguage(languages.get(0).id);

        Assertions.assertEquals(0, languageFacade.getAllLanguages().size());
    }
}
