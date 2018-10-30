package izo809.test.diagnostic;

import java.time.*;

public class Que47 {

    public static void main(String... args) {
        Period period = Period.between(LocalDate.of(2016, 2, 3), LocalDate.of(2016, Month.JANUARY, 1));
        System.out.println("period = " + period);
        Duration duration = Duration.between(LocalTime.of(1, 2, 3), LocalDateTime.of(2016, 1, 1, 1, 1));
        System.out.println("duration = " + duration);
    }
}
