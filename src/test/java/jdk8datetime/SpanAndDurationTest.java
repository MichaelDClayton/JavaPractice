package jdk8datetime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;

@RunWith(JUnit4.class)
public class SpanAndDurationTest {
    @Test
    public void test_getSpanBetweenLocalDates() {
        LocalDate localDateStart = LocalDate.of(2024, 7, 3);
        LocalDate localDateEnd = LocalDate.of(2024, 7, 26);
        Period period = Period.between(localDateStart,localDateEnd);

        int spanBetweenDates = period.getDays();
        assert (spanBetweenDates==23);
    }

    @Test
    public void test_getShortDuration(){
        Instant start = Instant.parse("2017-10-03T10:15:30.00Z");
        Instant end = Instant.parse("2017-10-03T10:16:30.00Z");;
        Duration duration = Duration.between(start, end);
        long durationSeconds =  duration.getSeconds();
        assert (durationSeconds == 60);
    }
}