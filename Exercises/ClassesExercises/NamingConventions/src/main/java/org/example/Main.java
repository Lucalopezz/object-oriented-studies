package org.example;

import org.example.exercise1.Convention;
import org.example.exercise1.NamingConventions;
import org.example.exercise2.Meeting;
import org.example.exercise2.Schedule;

import java.time.LocalTime;

public class Main {
    static void main() {
//        System.out.println("Está no parão: " + NamingConventions.isFollowingConvetion("testConvention", Convention.METHOD));
//        System.out.println("Const para metodo: " + NamingConventions.fromConstToVariable("TEST_CONSTANT"));
//        System.out.println("Var para const: " + NamingConventions.fromVariableToConst("testVariable"));

        Meeting meeting1 = new Meeting("Meeting 1", LocalTime.of(9, 0), LocalTime.of(9, 59));
        Meeting meeting2 = new Meeting("Meeting 2", LocalTime.of(10, 0), LocalTime.of(10, 59));
        Meeting meeting3 = new Meeting("Meeting 3", LocalTime.of(11, 0), LocalTime.of(12, 0));


        Schedule schedule = new Schedule();
        schedule.addMeeating(meeting1);
        schedule.addMeeating(meeting2);
        schedule.addMeeating(meeting3);

        System.out.println("Percentage spent in meetings: " + schedule.percentageSpentInMeetings() + "%");
        System.out.println(schedule.scheduleAsString());

        System.out.println("Remove a meeting:");
        schedule.removeMeeting(meeting2);
        System.out.println("Percentage spent in meetings: " + schedule.percentageSpentInMeetings() + "%");
        System.out.println(schedule.scheduleAsString());


    }
}
