package com.tedredington.ConsumerPriceIndexCalculator;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CpiRecordService {

    private final CpiRecordRepository recordRepository;

    public CpiRecordService(CpiRecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    public Optional<CpiRecord> findById(Integer id) {
        return recordRepository.findById(id);
    }
}
