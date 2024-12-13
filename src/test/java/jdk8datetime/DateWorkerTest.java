package jdk8datetime;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;


@RunWith(JUnit4.class)
public class DateWorkerTest extends TestCase {

    @Test
    public void test_LocalDate() {
        LocalDate localDate = LocalDate.of(2024, 12, 13);
        assertEquals(13, localDate.getDayOfMonth());
        assertEquals(2024, localDate.getYear());
        assertEquals(12, localDate.getMonthValue());
        assertEquals(12, Month.DECEMBER.getValue());
    }

    @Test
    public void test_LocalDateString() {
        LocalDate localDate = LocalDate.of(2024, 12, 13);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = localDate.format(formatter);
        assertEquals("2024-12-13", formattedDate);
    }



}