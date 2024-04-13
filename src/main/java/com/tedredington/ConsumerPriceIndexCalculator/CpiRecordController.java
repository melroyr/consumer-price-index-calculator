package com.tedredington.ConsumerPriceIndexCalculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CpiRecordController {

    private final CPIRecordService recordService;

    public CpiRecordController(CPIRecordService recordService) {
        this.recordService = recordService;
    }

    @GetMapping("/record/{id}" )
    public Optional<CpiRecord> getCpiRecord(@PathVariable("id") Integer id) {
        Optional<CpiRecord> record = recordService.findById(id);
        return record;
    }
}
