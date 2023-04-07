package com.wuza8.konnichiwoo.arts;

import com.wuza8.konnichiwoo.arts.dto.ArtPreviewDto;
import com.wuza8.konnichiwoo.arts.dto.ArtQueryDto;

import java.util.List;

interface ArtsRepository {
    Long add(ArtEntity artEntity);
    List<ArtPreviewDto> find(ArtQueryDto query);
}
