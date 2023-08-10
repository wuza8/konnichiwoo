package com.wuza8.konnichiwoo.gameplay;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.junit.jupiter.SpringExtension;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureDataMongo
class MongoAddHistoryTest {
    @Autowired
    MongoPlayerGameplayHistory history;
    MongoAdapterPlayerGameplayHistoryRepository adapter = new MongoAdapterPlayerGameplayHistoryRepository(history);

    @Test
    public void test(){
        adapter.addHistory("bobi", "one");
    }

}
