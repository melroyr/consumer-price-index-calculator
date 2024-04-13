package com.tedredington.ConsumerPriceIndexCalculator;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CpiRecordRepository extends CrudRepository<CpiRecord, Integer> {
}
