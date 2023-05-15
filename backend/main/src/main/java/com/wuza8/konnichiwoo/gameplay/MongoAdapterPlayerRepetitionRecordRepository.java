package com.wuza8.konnichiwoo.gameplay;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
class MongoAdapterPlayerRepetitionRecordRepository implements PlayerRepetitionRecordRepository{
    private MongoPlayerRepetitionRecordRepository repo;
    @Override
    public List<PlayerRepetitionRecord> getPlayerRecords(String userId) {
        return repo.findByUserId(userId);
    }

    @Override
    public void addPlayerRecord(PlayerRepetitionRecord record) {
        repo.save(record);
    }
}
