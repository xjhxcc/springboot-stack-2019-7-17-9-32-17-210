package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.CriminalCase;
import com.tw.apistackbase.entity.DetailInfo;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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
    @Test
    public void test_return_all_criminal_case_when_get_all_criminal_cases(){
        //given
        criminalCaseRepository.save(new CriminalCase("刑事案件1",123456));
        criminalCaseRepository.save(new CriminalCase("刑事案件2",12345));
        //when
        List<CriminalCase> all = criminalCaseRepository.findAllByOrderByTimeDesc();
        //then
        Assertions.assertEquals("刑事案件1",all.get(0).getName());
    }
    @Test
    public void test_return_all_criminal_case_when_get_criminal_by_name(){
        //given
        criminalCaseRepository.save(new CriminalCase("刑事1",123456));
        criminalCaseRepository.save(new CriminalCase("刑事2",12345));
        criminalCaseRepository.save(new CriminalCase("刑事1",152364));
        //when
        List<CriminalCase> all = criminalCaseRepository.findByName("刑事1");
        //then
        Assertions.assertEquals(152364,all.get(1).getTime());
    }
    @Test
    public void test_return_true_when_call_delete_by_id(){
        //given
        criminalCaseRepository.save(new CriminalCase("刑事1",123456));
        CriminalCase case2 = criminalCaseRepository.save(new CriminalCase("刑事2", 12345));
        //when
        criminalCaseRepository.deleteById(case2.getId());
        //then
        Assertions.assertEquals(1,criminalCaseRepository.findAll().size());
    }
    @Test
    public void test_return_criminal_case_when_find_all_contains_detail(){
        //given
        CriminalCase criminalCase = new CriminalCase("案件1", 789456,
                new DetailInfo("缺钱", "社会环境影响"));
        criminalCaseRepository.save(criminalCase);
        //when
        List<CriminalCase> actual=criminalCaseRepository.findAll();
        //then
        Assertions.assertEquals("缺钱",actual.get(0).getDetailInfo().getSubjective());
    }
}