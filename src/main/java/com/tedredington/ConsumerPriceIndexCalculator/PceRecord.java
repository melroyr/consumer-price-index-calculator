package com.tedredington.ConsumerPriceIndexCalculator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class PceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate date;
    private Double indexValue;

    public PceRecord(LocalDate date, Double indexValue) {
        this.date = date;
        this.indexValue = indexValue;
    }

    public PceRecord() {
    }


    public Integer getId() {
        return id;
    }

    public LocalDate getDate() {
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
