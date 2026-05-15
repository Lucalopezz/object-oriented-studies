package remake;

import java.time.LocalTime;

public class ReservationIdGenerator {
    private static int sequence = 10_000;

    public static String generateReservationId(){
        // “HTXX-YY-XX-ZZZZZ
        LocalTime now = LocalTime.now();
        int xx = now.getSecond();
        int yy = now.getMinute();
        return String.format("HT%02d-%02d-%02d-%05d", xx, yy, xx, sequence++);
    }
}
