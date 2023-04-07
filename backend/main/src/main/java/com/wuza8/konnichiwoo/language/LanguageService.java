package com.wuza8.konnichiwoo.language;

import com.wuza8.konnichiwoo.language.dto.LanguageAddDto;
import com.wuza8.konnichiwoo.language.dto.LanguageDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
class LanguageService {

    private LanguageRepository languageRepository;

    public List<LanguageDto> getAllLanguages(){
        List<LanguageDto> languages = new ArrayList<>();
        List<LanguageEntity> languagesFromDb = languageRepository.findAll();

        for(LanguageEntity language : languagesFromDb){
            languages.add(new LanguageDto(language.getId(), language.getName()));
        }

        return languages;
    }

    public void add(LanguageAddDto languageAddDto){
        LanguageEntity languageEntity = new LanguageEntity(
                null,
                languageAddDto.getLanguageName()
        );

        languageRepository.add(languageEntity);
    }

    public void remove(Long id){
        languageRepository.remove(id);
    }
}
