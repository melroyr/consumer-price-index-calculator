package com.tedredington.ConsumerPriceIndexCalculator;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DebtRecordRepository extends CrudRepository<DebtRecord, Integer> {
	
	public List<DebtRecord> findByDate(LocalDate date);
}
