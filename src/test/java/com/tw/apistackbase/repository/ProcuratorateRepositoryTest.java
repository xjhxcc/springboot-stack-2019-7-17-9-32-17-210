package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.Procuratorate;
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
public class ProcuratorateRepositoryTest {

    @Autowired
    private ProcuratorateRepository procuratorateRepository;

    @Test
    public void test_return_procuratorate__when_call_find_by_id(){
        //given
        Procuratorate procuratorate1 = procuratorateRepository
                .save(new Procuratorate("唐家派出所"));
        //when
        Procuratorate actual=procuratorateRepository.findById(procuratorate1.getId()).get();
        //then
        Assertions.assertEquals("唐家派出所",actual.getName());
    }

}