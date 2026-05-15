package org.example.exercise2;

import java.time.Duration;
import java.time.LocalTime;

public class Meeting {
    private String description;
    private LocalTime startTime;
    private LocalTime endTime;

    public Meeting(String description, LocalTime startTime, LocalTime endTime) {
        this.description = description;
        this.endTime = endTime;
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }
    public String getDescription() {
        return description;
    }

    public long durationInMinutes() {
        if (startTime == null || endTime == null) return 0;
        return Duration.between(startTime, endTime).toMinutes();

    }
}
