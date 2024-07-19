package com.tedredington.ConsumerPriceIndexCalculator;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PceRecordRepository extends CrudRepository<PceRecord, Integer> {
	
	public List<PceRecord> findByDate(LocalDate date);
}
