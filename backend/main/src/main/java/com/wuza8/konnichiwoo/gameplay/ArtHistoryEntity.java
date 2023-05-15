package com.wuza8.konnichiwoo.gameplay;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("arthistory")
@Getter
@Setter
@AllArgsConstructor
class ArtHistoryEntity {
    private String playerId;
    private List<String> artIds;
}
