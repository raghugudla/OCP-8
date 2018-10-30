package izo809.chap5;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

public class LocalDateEx {

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();

        System.out.println("now = " + now);

        System.out.println("now.plus(Period.ofDays(1)) = " + now.plus(Period.ofDays(1)));

        //UnsupportedTemporalTypeException: Unsupported unit: Days
        System.out.println("now.plus(Duration.ofDays(1)) = " + now.plus(Duration.ofDays(1)));
    }
}
