package com.tedredington.ConsumerPriceIndexCalculator;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CPIRecordRepository extends CrudRepository<CPIRecord, Integer> {
}
