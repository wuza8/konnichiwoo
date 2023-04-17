package com.wuza8.konnichiwoo.arts;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
class ArtPart {
    public String subtitle;
    public List<String> sentences;
}
