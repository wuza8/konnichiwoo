package com.wuza8.konnichiwoo.arts.dto;

import lombok.Builder;

import java.util.List;

@Builder
public class ArtPartDto {
    public String subtitle;
    public List<Long> sentences;
    public List<Long> newUsedSentences;
}
