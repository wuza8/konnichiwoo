package com.wuza8.konnichiwoo.arts.dto;

import lombok.Builder;

import java.util.List;

@Builder
public class ArtPartAddDto {
    public String subtitle;
    public List<String> sentences;
    public List<Long> newUsedSentences;
}
