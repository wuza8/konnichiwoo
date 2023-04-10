package com.wuza8.konnichiwoo.arts;

import com.wuza8.konnichiwoo.arts.enums.ArtType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

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
    private String artParts;
}
