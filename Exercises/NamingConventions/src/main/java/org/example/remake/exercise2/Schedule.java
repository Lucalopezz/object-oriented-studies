package org.example.remake.exercise2;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class Schedule {
    private LocalDate day;
    private LocalTime startTime;
    private LocalTime endTime;

    private Meeting[] meetings = new Meeting[10];
    private int meetingCount = 0;

    public Schedule(LocalDate day, LocalTime startTime, LocalTime endTime) {
        if (startTime.isAfter(endTime)) return;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void addMeeting(Meeting meeting) {
        if (meeting.getStartTime().isBefore(startTime) || meeting.getEndTime().isAfter(endTime)) {
            return;
        }
        for (int i = 0; i < meetingCount; i++) {
            Meeting m = meetings[i];
            if (meeting.getStartTime().isBefore(m.getEndTime()) && meeting.getEndTime().isAfter(m.getStartTime())) {
                return;
            }
        }
        meetings[meetingCount++] = meeting;
    }

    public void removeMeeting(Meeting meeting) {
        if (meeting == null) return;
        for (int i = 0; i < meetingCount; i++) {
            Meeting m = meetings[i];
            if (m.equals(meeting)) {
                meetings[i] = meetings[meetingCount - 1];
                meetings[meetingCount - 1] = null;
                meetingCount--;
            }

        }
    }

    public double percentageSpentInMeeting() {
        double timeSpendInMeeting = 0;
        for (int i = 0; i < meetingCount; i++) {
            timeSpendInMeeting += meetings[i].durationInMinutes();
        }
        return timeSpendInMeeting / (Duration.between(startTime, endTime).toMinutes()) * 100;
    }

    public String scheduleAsString(){
        String schedule = String.format("Schedule for %s from %s to %s:\n", day, startTime, endTime);

        for (int i = 0; i < meetingCount; i++) {
            Meeting m = meetings[i];
            schedule += String.format("- %s from %s to %s\n", m.getDescrition(), m.getStartTime(), m.getEndTime());
        }
        return schedule;
    }
}
