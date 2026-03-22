package org.example.exercise2;

import java.time.Duration;
import java.time.LocalTime;

public class Schedule {
    private LocalTime day;
    private LocalTime startTime;
    private LocalTime endTime;

    private final Meeting[] meetings = new Meeting[10];
    private int countMeeting = 0;

    public Schedule() {
        this.day = LocalTime.now();
        this.startTime = LocalTime.of(8, 0);
        this.endTime = LocalTime.of(18, 0);
    }

    public void addMeeating(Meeting meeting) {
        if (!isInScheduleTime(meeting) || isOverlapInSchedule(meeting)) {
            System.out.println("A meeting already exists at this time, or this time isn't in the schedule.");
            return;
        }
        meetings[countMeeting++] = meeting;
        System.out.println("Scheduled!");

    }

    public void removeMeeting(Meeting meeting) {
        int index = searchForOne(meeting);
        if (index == -1) {
            System.out.println("This meeting doesnt exist");
            return;
        }
        // Shift
        for (int i = index; i < countMeeting; i++) {
            meetings[i] = meetings[i + 1];
        }
        // Update countMeeting with the removed an set the last position to null
        meetings[--countMeeting] = null;
        System.out.println("Removed");

    }

    public double percentageSpentInMeetings() {
        long totalMinutes = 0;

        for (int i = 0; i < countMeeting; i++) {
            totalMinutes += meetings[i].durationInMinutes();
        }

        long scheduleMinutes =
                Duration.between(startTime, endTime).toMinutes();

        return (double) totalMinutes / scheduleMinutes * 100;
    }

    public String scheduleAsString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Schedule for ").append(day).append("\n");
        for (int i = 0; i < countMeeting; i++) {
            Meeting meet = meetings[i];
            sb.append("\n");
            sb.append(meet.getStartTime()).append(" - ").append(meet.getEndTime()).append(": ").append(meet.getDescription());
        }
        return sb.toString();
    }


    private int searchForOne(Meeting meeting) {
        for (int i = 0; i < countMeeting; i++) {
            if (meetings[i] == meeting) {
                return i;
            }
        }
        return -1;
    }

    private boolean isInScheduleTime(Meeting meeting) {
        return !meeting.getStartTime().isBefore(startTime) && !meeting.getEndTime().isAfter(endTime);
    }

    private boolean isOverlapInSchedule(Meeting newMeeting) {
        for (int i = 0; i < countMeeting; i++) {
            Meeting meet = meetings[i];

            if (meet.getStartTime().isBefore(newMeeting.getEndTime())
                    && newMeeting.getStartTime().isBefore(meet.getEndTime())) {
                return true;
            }
        }
        return false;
    }

}
//