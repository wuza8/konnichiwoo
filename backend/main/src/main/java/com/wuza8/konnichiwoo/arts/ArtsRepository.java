package com.wuza8.konnichiwoo.arts;

import com.wuza8.konnichiwoo.arts.dto.ArtQueryDto;

import java.util.List;

interface ArtsRepository {
    String add(ArtEntity artEntity);
    ArtEntity find(String artId);
    List<ArtEntity> findArts(ArtQueryDto query);
}
