package org.example;

import java.time.LocalDateTime;

public class ReservationIdGenerator {
    private static int sequence = 10000;

    public static String generateId() {
        LocalDateTime now = LocalDateTime.now();

        int xx = now.getSecond();
        int yy = now.getMinute();

        String id = String.format("HT%02d-%02d-%02d-%05d", xx, yy, xx, sequence);
        sequence++;

        return id;


    }
}
