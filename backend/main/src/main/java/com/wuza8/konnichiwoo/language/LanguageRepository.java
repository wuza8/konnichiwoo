package com.wuza8.konnichiwoo.language;

import java.util.List;

interface LanguageRepository {

    public void add(LanguageEntity languageEntity);
    public void remove(Long id);
    public List<LanguageEntity> findAll();
}
