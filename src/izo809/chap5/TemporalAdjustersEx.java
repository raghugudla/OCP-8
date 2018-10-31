package izo809.chap5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjustersEx {

    private static void ex1() {
        ZonedDateTime zdt = ZonedDateTime.now();
        System.out.println("zdt: " + zdt);
        System.out.println("1 = " + zdt.with(TemporalAdjusters.next(DayOfWeek.MONDAY)));
        System.out.println("2 = " + zdt.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY)));
        System.out.println("3 = " + zdt.with(TemporalAdjusters.firstDayOfNextYear()));
        System.out.println();

        System.out.println("LocalDate-1 " + LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.MONDAY)));
        System.out.println("LocalDate-2 " + LocalDate.now().with(TemporalAdjusters.lastDayOfYear()));

//        System.out.println("LocalTime-1 " + LocalTime.now().with(TemporalAccessor.));
//        System.out.println("LocalTime-2 " + LocalTime.now().with(TemporalAdjusters.lastDayOfYear()));
    }

    public static void main(String[] args) {
        ex1();
    }
}
