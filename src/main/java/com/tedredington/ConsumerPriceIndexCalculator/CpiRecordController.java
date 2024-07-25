package com.tedredington.ConsumerPriceIndexCalculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
public class CpiRecordController {

    private final CpiRecordService recordService;

    public CpiRecordController(CpiRecordService recordService) {
        this.recordService = recordService;
    }

    @GetMapping("/cpirecord/{id}" )
    public Optional<CpiRecord> getCpiRecord(@PathVariable("id") Integer id) {
        Optional<CpiRecord> record = recordService.findById(id);
        return record;
    }
    
    @GetMapping("/cpirecord/date" )
    public List<CpiRecord> getCpiRecord() {
    	
    	LocalDate date = LocalDate.parse("2023-01-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        List<CpiRecord> records = recordService.findByDate(date);
        System.out.println("CPI Date Count: " + records.size());
        return records;
    }
    
    @GetMapping("/cpirecords" )
    public List<CpiRecord> getCpiRecords() {
        List<CpiRecord> records = recordService.findAll();
        return records;
    }
}
