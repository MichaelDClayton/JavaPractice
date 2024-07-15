package jdk8datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateWorker {
    public static void main(String[] args) {
        getLocalDate();
        System.out.println("*********************");
        getLocalTime();
        System.out.println("*********************");
        getLocalDateAndTime();
        System.out.println("*********************");
        formatLocalDateTimeFormatted();
        System.out.println("*********************");
        formatTimezone();
    }

    public static void getLocalDate(){
        LocalDate localDate = LocalDate.now();
        System.out.println("Local Date: "+localDate);
    }

    public static void getLocalTime(){
        LocalTime localTime = LocalTime.now();
        System.out.println("Local Time: "+localTime);
    }

    public static void getLocalDateAndTime(){
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("Local DateTime: "+localDateTime);
    }

    public static void formatLocalDateTimeFormatted(){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        System.out.println(localDateTime.format(dateFormat));
    }

    public static void formatTimezone(){
        ZoneId tokyo = ZoneId.of("Asia/Tokyo");
        ZonedDateTime currentZone = ZonedDateTime.now();
        ZonedDateTime tokyoZone =
                currentZone.withZoneSameInstant(tokyo);
        System.out.println("tokyo time zone is " +
                tokyoZone);
        DateTimeFormatter dateTimeFormatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatedDateTime = tokyoZone.format(dateTimeFormatter);
        System.out.println("formatted tokyo time zone "+
                formatedDateTime);
    }

}
