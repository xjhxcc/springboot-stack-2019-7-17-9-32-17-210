package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.CriminalCase;
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
public class CriminalCaseRepositoryTest {
    @Autowired
    private CriminalCaseRepository criminalCaseRepository;

    @Test
    public void test_return_criminal_case_when_get_criminal_case_by_id(){
        //given
        long time=123456789;
        CriminalCase criminalCase1 = criminalCaseRepository.save(new CriminalCase("张某某持刀抢劫案", time));
        //when
        CriminalCase actual=criminalCaseRepository.findById(criminalCase1.getId()).get();
        //then
        Assertions.assertEquals("张某某持刀抢劫案",actual.getName());
    }
}