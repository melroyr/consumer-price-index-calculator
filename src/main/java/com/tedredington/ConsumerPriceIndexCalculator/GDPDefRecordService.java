package com.tedredington.ConsumerPriceIndexCalculator;

import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class GDPDefRecordService {

    private final GDPDefRecordRepository recordRepository;

    public GDPDefRecordService(GDPDefRecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    public Optional<GDPDefRecord> findById(Integer id) {
        return recordRepository.findById(id);
    }
    
    public List<GDPDefRecord> findByDate(LocalDate date) {
    	return recordRepository.findByDate(date);
    }
    
    public List<GDPDefRecord> findAll() {
    	Iterable<GDPDefRecord> iterable = recordRepository.findAll();
    	List<GDPDefRecord> records = Streamable.of(iterable).toList();
    	
    	Double value = 0.00;
    	Double currValue = 0.00;
    	int up=0, down=0;
    	for(GDPDefRecord record: records) {
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
