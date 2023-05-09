package com.wuza8.konnichiwoo.gameplay;

import java.util.List;

interface PlayerRepetitionRecordRepository {
    List<PlayerRepetitionRecord> getPlayerRecords(String userId);
    void addPlayerRecord(PlayerRepetitionRecord record);

}
