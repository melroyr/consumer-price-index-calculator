package com.tedredington.ConsumerPriceIndexCalculator;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GDPDefRecordRepository extends CrudRepository<GDPDefRecord, Integer> {
	
	public List<GDPDefRecord> findByDate(LocalDate date);
}
