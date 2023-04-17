package com.wuza8.konnichiwoo.arts.dto;

import com.wuza8.konnichiwoo.arts.enums.ArtType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArtPreviewDto {
    private String id;
    private String name;
    private String type;
    private String mapper;
    private Long progress;
    private Long thumbs;
}
