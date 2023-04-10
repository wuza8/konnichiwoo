package com.wuza8.konnichiwoo.arts.dto;

import com.wuza8.konnichiwoo.arts.enums.ArtType;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;

@AllArgsConstructor
@Builder
public class ArtAddDto {
    public String textName;
    public Long languageId;
    public String memoAuthorUID;
    public String originalAuthor;
    public ArtType artType;
    public String artUrl;
    public List<ArtPartAddDto> artParts;
    public List<SentenceAddWithArtDto> addedSentences;
}
