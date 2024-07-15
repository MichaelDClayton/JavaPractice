package jdk8datetime;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

@RunWith(JUnit4.class)
public class DateWorkerTest extends TestCase {

    @Test
    public void test_LocalDate() {
        LocalDateTime localDateTime = LocalDateTime.now();
        Integer day = localDateTime.getDayOfMonth();
        Integer month = localDateTime.getMonthValue();
        Integer year = localDateTime.getYear();

        Integer dayOfMonth = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        Integer monthOfYear = Calendar.getInstance().get(Calendar.MONTH) + 1;
        Integer calYear = Calendar.getInstance().get(Calendar.YEAR);
        assertEquals(day, dayOfMonth);
        assertEquals(month, monthOfYear);
        assertEquals(year, calYear);

    }

    @Test
    public void test_LocalDateString() {
        String yearString = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = localDate.format(formatter);
        assert (formattedDate.startsWith(yearString));
    }
}