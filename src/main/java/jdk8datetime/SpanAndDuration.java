package jdk8datetime;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;

public class SpanAndDuration {


    public static int getSpanBetweenLocalDates(){
        LocalDate localDateStart = LocalDate.of(2024, 7, 3);
        LocalDate localDateEnd = LocalDate.of(2024, 7, 26);
        Period period = Period.between(localDateStart,localDateEnd);
        return period.getDays();

    }

    public static long getShortDuration(){
        Instant start = Instant.parse("2017-10-03T10:15:30.00Z");
        Instant end = Instant.parse("2017-10-03T10:16:30.00Z");;
        Duration duration = Duration.between(start, end);
        return duration.getSeconds();
    }
}
