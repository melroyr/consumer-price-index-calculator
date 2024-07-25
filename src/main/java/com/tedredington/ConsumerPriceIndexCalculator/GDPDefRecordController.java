package com.tedredington.ConsumerPriceIndexCalculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
public class GDPDefRecordController {

    private final GDPDefRecordService recordService;

    public GDPDefRecordController(GDPDefRecordService recordService) {
        this.recordService = recordService;
    }

    @GetMapping("/gdpdefrecord/{id}" )
    public Optional<GDPDefRecord> getGDPDefRecord(@PathVariable("id") Integer id) {
        Optional<GDPDefRecord> record = recordService.findById(id);
        return record;
    }
    
    @GetMapping("/gdpdefrecord/date" )
    public List<GDPDefRecord> getGDPDefRecord() {
    	
    	LocalDate date = LocalDate.parse("2024-01-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        List<GDPDefRecord> records = recordService.findByDate(date);
        System.out.println("CPI Date Count: " + records.size());
        return records;
    }
    
    @GetMapping("/gdpdefrecords" )
    public List<GDPDefRecord> getGDPDefRecords() {
        List<GDPDefRecord> records = recordService.findAll();
        return records;
    }
}
