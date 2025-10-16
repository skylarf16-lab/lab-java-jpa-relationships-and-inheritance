package com.example.prsystem.task;

import jakarta.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class BillableTask extends Task {

    private BigDecimal hourlyRate;

    public BillableTask() {}

    public BigDecimal getHourlyRate() { return hourlyRate; }
    public void setHourlyRate(BigDecimal hourlyRate) { this.hourlyRate = hourlyRate; }
}