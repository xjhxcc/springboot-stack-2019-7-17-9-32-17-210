package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.CriminalCase;
import org.springframework.data.repository.CrudRepository;

public interface CriminalCaseRepository extends CrudRepository<CriminalCase,Long> {
}
