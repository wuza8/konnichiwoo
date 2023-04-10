package com.wuza8.konnichiwoo.arts.dto;

import com.wuza8.konnichiwoo.arts.enums.ArtType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ArtDto {
    private Long id;
    private String textName;
    private Long languageId;
    private String memoAuthorUID;
    private String originalAuthor;
    private ArtType artType;
    private String artUrl;
    private List<ArtPartDto> artParts;
}
