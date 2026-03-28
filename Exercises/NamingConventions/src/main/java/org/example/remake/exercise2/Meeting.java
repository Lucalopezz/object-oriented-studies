package org.example.remake.exercise2;

import java.time.Duration;
import java.time.LocalTime;

public class Meeting {
    private String descrition;
    private LocalTime startTime;
    private LocalTime endTime;

    public long durationInMinutes(){
        return Duration.between(startTime, endTime).toMinutes();
    }

    public String getDescrition() {
        return descrition;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public Meeting(String descrition, LocalTime startTime, LocalTime endTime) {
        this.descrition = descrition;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
