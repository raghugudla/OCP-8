package izo809.chap5;

import java.time.Duration;
import java.time.LocalTime;
import java.time.Period;

public class LocalTimeEx {

    public static void main(String[] args) {
        LocalTime now = LocalTime.now();

        System.out.println("now = " + now);

        System.out.println("now.plus(Duration.ofDays(1)) = " + now.plus(Duration.ofDays(100)));

        //UnsupportedTemporalTypeException: Unsupported unit: Days
        System.out.println("now.plus(Period.ofDays(1)) = " + now.plus(Period.ofDays(1)));
    }
}
