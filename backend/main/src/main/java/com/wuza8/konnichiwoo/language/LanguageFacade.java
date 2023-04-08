package com.wuza8.konnichiwoo.language;

import com.wuza8.konnichiwoo.language.dto.LanguageAddDto;
import com.wuza8.konnichiwoo.language.dto.LanguageDto;
import lombok.AllArgsConstructor;

import java.util.List;


/**
 *  This module provides a possibility to create new possible to learn
 *  languages in the app. At this point there's only japanese language
 *  harcoded - see LanguageConfig
 */
@AllArgsConstructor
public class LanguageFacade {
    private LanguageService languageService;

    public List<LanguageDto> getAllLanguages(){
        return languageService.getAllLanguages();
    }

    public void addLanguage(LanguageAddDto languageAddDto) {
        languageService.add(languageAddDto);
    }

    public void removeLanguage(Long id) {
        languageService.remove(id);
    }
}
