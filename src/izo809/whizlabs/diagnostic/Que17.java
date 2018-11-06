package izo809.whizlabs.diagnostic;

import java.util.function.Predicate;

public class Que17 {

    public static void main(String... args) {
        Predicate<Integer> p1 = i -> i % 2 == 0;
        //Predicate p2 = (Integer i) -> i%2==0;
        Predicate p3 = i -> (Integer) i % 2 == 0;
    }
}
