package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimePractice {
    public static void main(String[] args) throws InterruptedException, ParseException {

        System.out.println("-----------------DATE-----------------------");
        //Date
        Date date = new Date();
        System.out.println(date);
        //add 2 sec delay
        Thread.sleep(2000);
        //Date
        Date date1 = new Date();
        System.out.println(date1);
        //compare dates - check on console time difference
        System.out.println(date.compareTo(date1));

        System.out.println("-----------------SimpleDateFormat-----------------------");
        //SimpleDateFormat(java.text)
        //"yyyy-MM-dd hh:mm:ss:SS a" -> 2020-03-21 08:58:18:680 PM
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SS a");
        System.out.println(format.format(date));
        //"MM dd yy" -> 03 21 20
        SimpleDateFormat format1 = new SimpleDateFormat("MM dd yy");
        System.out.println(format1.format(date));
        //"MMMM dd yyyy" -> March 21 2020
        SimpleDateFormat format2 = new SimpleDateFormat("MMMM dd yyyy");
        System.out.println(format2.format(date));

        System.out.println("-----------------LocalDate-----------------------");
        //LocalDate(java.time)
        LocalDate date2 = LocalDate.now();
        System.out.println(date2);
        LocalTime time = LocalTime.now();
        System.out.println(time);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        System.out.println("-----------------Format-----------------------");
        //LocalDate Custom
        LocalDate customDate = LocalDate.of(2020,03,21);
        System.out.println(customDate);
        //DateTimeFormatter(java.time.format)
        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss:SS a")));

        System.out.println("-----------------AddYears----------------------");
        LocalDateTime dateTime = LocalDateTime.now();
        dateTime = dateTime.plusYears(200);
        System.out.println(dateTime);

        System.out.println("-----------------ZonedDateTime----------------------");
        //ZonedDateTime(java.time)
        ZonedDateTime dateTime1 = ZonedDateTime.now(ZoneId.of(ZoneId.SHORT_IDS.get("AGT")));
        System.out.println(dateTime1);


    }
}
