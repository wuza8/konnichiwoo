package com.wuza8.konnichiwoo.gameplay;

import java.util.List;

interface PlayerGameplayHistoryRepository {
    void addHistory(String userId, String artId);
    ArtHistoryEntity getLastPlayed(String userId);
}
