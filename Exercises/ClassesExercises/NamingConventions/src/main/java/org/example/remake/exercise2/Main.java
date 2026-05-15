package org.example.remake.exercise2;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Meeting meeting1 = new Meeting("Meeting 1", LocalTime.of(9, 0), LocalTime.of(9, 59));
        Meeting meeting2 = new Meeting("Meeting 2", LocalTime.of(10, 0), LocalTime.of(10, 59));
        Meeting meeting3 = new Meeting("Meeting 3", LocalTime.of(11, 0), LocalTime.of(12, 0));

        Schedule schedule = new Schedule(LocalDate.now(), LocalTime.of(8, 0), LocalTime.of(18, 0));
        schedule.addMeeting(meeting1);
        schedule.addMeeting(meeting2);
        schedule.addMeeting(meeting3);

        System.out.println("Percentage spent in meetings: " + schedule.percentageSpentInMeeting() + "%");
        System.out.println(schedule.scheduleAsString());

        System.out.println("Remove a meeting:");
        schedule.removeMeeting(meeting2);
        System.out.println("Percentage spent in meetings: " + schedule.percentageSpentInMeeting() + "%");
        System.out.println(schedule.scheduleAsString());
    }
}
