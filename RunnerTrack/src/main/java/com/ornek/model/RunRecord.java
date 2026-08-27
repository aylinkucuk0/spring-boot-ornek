package com.ornek.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "run_records")
public class RunRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double distanceKm;
    private String durationTime;
    private LocalDate runDate;
    private boolean isRecord;

    @ManyToOne
    @JoinColumn(name = "athlete_id")
    private Athlete athlete;

    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getDistanceKm() { return distanceKm; }
    public void setDistanceKm(double distanceKm) { this.distanceKm = distanceKm; }

    public String getDurationTime() { return durationTime; }
    public void setDurationTime(String durationTime) { this.durationTime = durationTime; }

    public LocalDate getRunDate() { return runDate; }
    public void setRunDate(LocalDate runDate) { this.runDate = runDate; }

    public boolean isRecord() { return isRecord; }
    public void setRecord(boolean record) { isRecord = record; }

    public Athlete getAthlete() { return athlete; }
    public void setAthlete(Athlete athlete) { this.athlete = athlete; }
}