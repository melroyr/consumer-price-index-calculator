package com.tedredington.ConsumerPriceIndexCalculator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class CPIRecord {

    @Id
    private Integer id;
    private LocalDateTime date;
    private Double indexValue;

    public CPIRecord(LocalDateTime date, Double indexValue) {
        this.date = date;
        this.indexValue = indexValue;
    }

    public Integer getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Double getIndexValue() {
        return indexValue;
    }

    @Override
    public String toString() {
        return "CPIRecord{" +
                "id=" + id +
                ", date=" + date +
                ", indexValue=" + indexValue +
                '}';
    }
}
