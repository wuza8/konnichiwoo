package com.wuza8.konnichiwoo.arts;

import com.wuza8.konnichiwoo.arts.dto.ArtDto;
import com.wuza8.konnichiwoo.arts.dto.ArtPartDto;
import com.wuza8.konnichiwoo.arts.enums.ArtType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document("art")
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ArtEntity {
    @Id
    private String id;
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
