package com.tedredington.ConsumerPriceIndexCalculator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class DebtRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate date;
    private double debtAmount;
    private Integer quarter;

    public DebtRecord(LocalDate date, double debtAmount, Integer quarter) {
        this.date = date;
        this.debtAmount = debtAmount;
        this.quarter = quarter;
    }

    public DebtRecord() {
    }


    public Integer getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

	public double getDebAmount() {
        return debtAmount;
    }
	
	public Integer getQuarter() {
		return quarter;
	}

    @Override
    public String toString() {
        return "CPIRecord{" +
                "id=" + id +
                ", date=" + date +
                ", debtAmount=" + debtAmount +
                ", quarter=" + quarter +
                '}';
    }
}
