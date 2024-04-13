package com.tedredington.ConsumerPriceIndexCalculator;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CPIRecordService {

    private CpiRecordRepository recordRepository;

    public CPIRecordService(CpiRecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    public Optional<CpiRecord> findById(Integer id) {
        return recordRepository.findById(id);
    }
}
