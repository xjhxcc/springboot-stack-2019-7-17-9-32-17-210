package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.DetailInfo;
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
public class DetailInfoRepositoryTest {
    @Autowired
    private DetailInfoRepository detailInfoRepository;
    @Test
    public void test_return_criminal_case_when_get_criminal_case_by_id(){
        //given
        long time=123456789;
        DetailInfo detailInfo = detailInfoRepository
                .save(new DetailInfo("缺钱", "社会环境影响"));
        //when
        DetailInfo actual=detailInfoRepository.findById(detailInfo.getId()).get();
        //then
        Assertions.assertEquals("缺钱",actual.getSubjective());
    }
}