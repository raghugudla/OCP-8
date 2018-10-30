package izo809.chap5;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class ZonedDateTimeTest {

    private static void ex1() {
        LocalDateTime localDateTime = LocalDateTime.of(2018,1,2,3,4,5);
        ZonedDateTime zdt = ZonedDateTime.of(localDateTime, ZoneId.of("CET"));
        System.out.println("zdt: " + zdt);
        System.out.println("1..." + zdt.withZoneSameInstant(ZoneId.of("Asia/Dhaka")));
        System.out.println("2..." + zdt.toInstant().atZone(ZoneId.of("Asia/Dhaka")));
        System.out.println("3..." + ZonedDateTime.ofInstant(zdt.toInstant(), ZoneId.of("Asia/Dhaka")));

        System.out.println("Now at a different zone..." + ZonedDateTime.now(ZoneId.of("Asia/Dhaka")));
        System.out.println();
        System.out.println("Instant.now() = " + Instant.now());
    }

    private static void ex2() {
        LocalDateTime localDateTime = LocalDateTime.of(2018,10,28,2, 30);
        System.out.println("localDateTime = " + localDateTime);

        ZonedDateTime zonedDateTime2a = ZonedDateTime.of(localDateTime, ZoneId.of("CET"));
        System.out.println("zonedDateTime2a = " + zonedDateTime2a);

        ZonedDateTime zonedDateTime2b = zonedDateTime2a.plus(1, ChronoUnit.HOURS);
        System.out.println("zonedDateTime2b = " + zonedDateTime2b);

        System.out.println("ChronoUnit.HOURS.between(zonedDateTime1, zonedDateTime2) = "
                + ChronoUnit.HOURS.between(zonedDateTime2a, zonedDateTime2b));

        ZonedDateTime zonedDateTime3 = zonedDateTime2b.plus(1, ChronoUnit.HOURS);
        System.out.println("zonedDateTime2 = " + zonedDateTime3);

        System.out.println("ChronoUnit.HOURS.between(zonedDateTime2a, zonedDateTime3) = "
                + ChronoUnit.HOURS.between(zonedDateTime2a, zonedDateTime3));

        System.out.println("ChronoUnit.HOURS.between(zonedDateTime2b, zonedDateTime3) = "
                + ChronoUnit.HOURS.between(zonedDateTime2b, zonedDateTime3));
    }

    public static void main(String[] args) {
        ex1();
    }

}
