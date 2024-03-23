package com.tedredington.ConsumerPriceIndexCalculator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CPIRecordController {

    private final CPIRecordService recordService;

    public CPIRecordController(CPIRecordService recordService) {
        this.recordService = recordService;
    }

    @GetMapping
    public CPIRecordResponse getCpiRecord(){
        return new CPIRecordResponse(1,1.0);
    }
}
