package jdk8datetime;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.time.*;

@RunWith(JUnit4.class)
public class TestZoneDateTime {
    @Test
    public void test_ZoneId(){
         /*
          *
          * Use this to list all ZoneId(s).
          * Set<String> zoneIds = ZoneId.getAvailableZoneIds();
          * zoneIds.forEach(System.out::println);
        */

        ZoneId tokyo = ZoneId.of("Asia/Tokyo");
        ZonedDateTime currentZone = ZonedDateTime.now();
        ZonedDateTime tokyoDateTime =
                currentZone.withZoneSameInstant(tokyo);

        ZoneId testedZoneId = tokyoDateTime.getZone();
        Assert.assertEquals("Asia/Tokyo", testedZoneId.getId());

    }


    @Test
    public void test_DurationInHours_Between_ZoneDateTime(){
        /*
         *
         * Use this to list all ZoneId(s).
         * Set<String> zoneIds = ZoneId.getAvailableZoneIds();
         * zoneIds.forEach(System.out::println);
         */

        ZoneId tokyoZone = ZoneId.of("Asia/Tokyo");
        ZoneId nycZone = ZoneId.of("America/New_York");


        ZonedDateTime tokyoDateTime =
                ZonedDateTime.of(LocalDateTime.now(), tokyoZone);
        ZonedDateTime nycDateTime =
                ZonedDateTime.of(LocalDateTime.now(), nycZone);

       Duration duration = Duration.between(tokyoDateTime, nycDateTime);
       long differenceInHours = duration.toHours();
       Assert.assertEquals(14, differenceInHours);

    }
}
