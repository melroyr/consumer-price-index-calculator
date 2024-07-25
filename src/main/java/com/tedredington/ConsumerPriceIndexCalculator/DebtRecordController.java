package com.tedredington.ConsumerPriceIndexCalculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
public class DebtRecordController {

    private final DebtRecordService recordService;

    public DebtRecordController(DebtRecordService recordService) {
        this.recordService = recordService;
    }

    @GetMapping("/debtrecord/{id}" )
    public Optional<DebtRecord> getDebtRecord(@PathVariable("id") Integer id) {
        Optional<DebtRecord> record = recordService.findById(id);
        return record;
    }
    
    @GetMapping("/debtrecord/date" )
    public List<DebtRecord> geDebtRecord() {
    	
    	LocalDate date = LocalDate.parse("2023-09-30", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        List<DebtRecord> records = recordService.findByDate(date);
        System.out.println("CPI Date Count: " + records.size());
        return records;
    }
    
    @GetMapping("/debtrecords" )
    public List<DebtRecord> getDebtRecords() {
        List<DebtRecord> records = recordService.findAll();
        return records;
    }
}
