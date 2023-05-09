package com.wuza8.konnichiwoo.gameplay;

import java.util.ArrayList;
import java.util.List;

class InMemoryPlayerRepetitionRecordRepositoryImpl implements PlayerRepetitionRecordRepository{
    List<PlayerRepetitionRecord> records = new ArrayList<>();

    public List<PlayerRepetitionRecord> getPlayerRecords(String userId){
        List<PlayerRepetitionRecord> playerRecords = new ArrayList<>();
        for(PlayerRepetitionRecord record : records){
            if(record.getUserId().equals(userId))
                playerRecords.add(record);
        }
        return playerRecords;
    }

    @Override
    public void addPlayerRecord(PlayerRepetitionRecord record){
        records.add(record);
    }
}
