package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.Procurator;
import com.tw.apistackbase.entity.Procuratorate;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

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
    @Test
    public void test_return_procuratorate__when_call_find_all_contains_procurator(){
        //given
        Procurator procurator1=new Procurator("张三");
        Procurator procurator2=new Procurator("李四");
        List<Procurator> list=new ArrayList<>();
        list.add(procurator1);
        list.add(procurator2);
        Procuratorate procuratorate1 = procuratorateRepository
                .save(new Procuratorate("中山检察院",list));
        //when
        Procuratorate actual=procuratorateRepository.findAll().get(0);
        //then
        Assertions.assertEquals("张三",actual.getProcurator().get(0).getName());
    }



}