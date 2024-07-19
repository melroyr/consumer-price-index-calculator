package com.tedredington.ConsumerPriceIndexCalculator;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

@Service
public class PceRecordService {

    private final PceRecordRepository recordRepository;

    public PceRecordService(PceRecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    public Optional<PceRecord> findById(Integer id) {
        return recordRepository.findById(id);
    }
    
    public List<PceRecord> findByDate(LocalDate date) {
    	return recordRepository.findByDate(date);
    }
    
    public List<PceRecord> findAll() {
    	Iterable<PceRecord> iterable = recordRepository.findAll();
    	List<PceRecord> records = Streamable.of(iterable).toList();
    	
    	Double value = 0.00;
    	Double currValue = 0.00;
    	int up=0, down=0;
    	for(PceRecord record: records) {
    		currValue = record.getIndexValue();
    		if (currValue > value) {
    			value = currValue;
    			up ++;
    		} else {
    			down ++;
    		}
    		
    	}
    	System.out.println("Up: " + up);
    	System.out.println("Down: " + down);
    	
    	return records;
    }
}
