package com.tedredington.ConsumerPriceIndexCalculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
public class PceRecordController {

    private final PceRecordService recordService;

    public PceRecordController(PceRecordService recordService) {
        this.recordService = recordService;
    }

    @GetMapping("/pcerecord/{id}" )
    public Optional<PceRecord> getPceRecord(@PathVariable("id") Integer id) {
        Optional<PceRecord> record = recordService.findById(id);
        return record;
    }
    
    @GetMapping("/pcerecord/date" )
    public List<PceRecord> getPceRecord() {
    	
    	LocalDate date = LocalDate.parse("2023-05-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        List<PceRecord> records = recordService.findByDate(date);
        System.out.println("PCE Date Count: " + records.size());
        return records;
    }
    
    @GetMapping("/pcerecords" )
    public List<PceRecord> getPceRecords() {
        List<PceRecord> records = recordService.findAll();
        return records;
    }
}
