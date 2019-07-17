package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.Procurator;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProcuratorRepositoryTest {
    @Autowired
    private ProcuratorRepository procuratorRepository;
    @Test
    public void test_return_procurator__when_call_find_by_id(){
        //given
        Procurator procurator1 = procuratorRepository
                .save(new Procurator("李小明"));
        //when
        Procurator actual=procuratorRepository.findById(procurator1.getId()).get();
        //then
        Assertions.assertEquals("李小明",actual.getName());
    }

}