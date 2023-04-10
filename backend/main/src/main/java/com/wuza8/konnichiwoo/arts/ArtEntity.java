package com.wuza8.konnichiwoo.arts;

import com.wuza8.konnichiwoo.arts.dto.ArtDto;
import com.wuza8.konnichiwoo.arts.dto.ArtPartDto;
import com.wuza8.konnichiwoo.arts.enums.ArtType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@Builder
@Getter
@Setter
class ArtEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String textName;
    private Long languageId;
    private String memoAuthorUID;
    private String originalAuthor;
    private ArtType artType;
    private String artUrl;
    private List<ArtPart> artParts;

    public ArtDto createDto(){
        List<ArtPartDto> artPartDtos = new ArrayList<>();

        for(ArtPart artPart : artParts){
            artPartDtos.add(ArtPartDto.builder()
                            .subtitle(artPart.subtitle)
                            .sentences(new ArrayList<>(artPart.sentences))
                    .build());
        }

        return ArtDto.builder()
                .id(id)
                .textName(textName)
                .languageId(languageId)
                .memoAuthorUID(memoAuthorUID)
                .originalAuthor(originalAuthor)
                .artType(artType)
                .artUrl(artUrl)
                .artParts(artPartDtos)
                .build();
    }
}
