package izo809.chap5;

import java.time.Duration;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodEx {

    public static void main(String[] args) {
        String m1 = Duration.of(1, ChronoUnit.MINUTES).toString();
        System.out.println("m1 = " + m1);
        String m2 = Duration.ofMinutes(1).toString();
        System.out.println("m2 = " + m2);
        String s = Duration.ofSeconds(60).toString();
        System.out.println("s = " + s);
        String d = Duration.ofDays(1).toString();
        System.out.println("d = " + d);
        String p = Period.ofDays(1).toString();
        System.out.println("p = " + p);

        System.out.println("m1.equals(m2) = " + m1.equals(m2));
        System.out.println("m1.equals(s) = " + m1.equals(s));

        System.out.println(Duration.ofMinutes(1) + " = " + Duration.ofSeconds(60));
        System.out.println(Duration.ofMinutes(60) + " = " + Duration.ofHours(1));

        System.out.println(Period.ofMonths(12) + " != " + Period.ofYears(1));
    }
}
