package com.tedredington.ConsumerPriceIndexCalculator;

import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class DebtRecordService {

    private final DebtRecordRepository recordRepository;

    public DebtRecordService(DebtRecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    public Optional<DebtRecord> findById(Integer id) {
        return recordRepository.findById(id);
    }
    
    public List<DebtRecord> findByDate(LocalDate date) {
    	return recordRepository.findByDate(date);
    }
    
    public List<DebtRecord> findAll() {
    	Iterable<DebtRecord> iterable = recordRepository.findAll();
    	List<DebtRecord> records = Streamable.of(iterable).toList();
    	
    	Double value = 0.00;
    	Double currValue = 0.00;
    	int up=0, down=0;
    	
    	double initalValue = 34000000000.00;
    	double jump;
    	for (DebtRecord record: records) {
    		 jump = initalValue - record.getDebAmount();
    		 if (jump > 25000000000000.00) {
     			System.out.println("Jumped by 2.5 trillion: " + record.getDate());
     		} else if (jump > 2000000000000.00) {
    			System.out.println("Jumped by 2 trillion: " + record.getDate());
    		} else if (jump > 15000000000000.00) {
    			System.out.println("Jumped by 1.5 trillion" + record.getDate()) ;
    		} else if (jump > 1000000000000.00) {
    			System.out.println("Jumped by 1 trillion" + record.getDate() ) ;
    		}
    		initalValue = record.getDebAmount();
    	}
    	
    	return records;
    }
}
