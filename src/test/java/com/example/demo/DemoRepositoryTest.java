package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@Slf4j
public class DemoRepositoryTest {
    @Autowired
    DemoRepository repo;

    @Test
    public void whenUpdatingElementCollectionEnversErrorsOut(){
        // prepare
        var entity = new DemoModel(new DemoCompositeKey(1,1), Map.of("A", "AAB"));
        repo.save(entity);
        log.info("Entity addition ok. Updating");


        // update once
        entity = repo.findById(new DemoCompositeKey(1, 1)).get();
        entity.getSomeCollection().put("A", "AAA");
        entity.getSomeCollection().put("B", "AAB");
        repo.save(entity);

        // update twice
        entity = repo.findById(new DemoCompositeKey(1, 1)).get();
        entity.getSomeCollection().put("A", "AAC");
        entity.getSomeCollection().put("B", "AAB");
        repo.save(entity);
    }
}