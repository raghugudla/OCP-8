package izo809.chap4;

import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {
        staticMethods();
        //instanceMethods_orElse();

    }

    public static void instanceMethods_orElse() {

        Optional<String> opt = Optional.ofNullable("A");
        System.out.println(opt.orElse(get()));  // orElse called even though opt holds a value
        System.out.println("---------------------");
        System.out.println(opt.orElseGet(OptionalTest::get));
    }

    public static String get() {
        System.out.println("get called even though opt holds a value ");
        return "orElse";
    }

    public static void instanceMethods() {

        Optional<Double> opt = average(90, 100);

        if (opt.isPresent())
            System.out.println(opt.get());

        opt.ifPresent(System.out::println);

    }

    public static void staticMethods() {
        System.out.println(average(90, 100));
        System.out.println(average());

        Optional<Double> opt = average();
        if (opt.isPresent())
            System.out.println(opt.get());

        Optional<Double> opt1 = average(90, 100);
        System.out.println(opt1.get());

        System.out.println(Optional.ofNullable((null)));
        System.out.println(Optional.of(null));  //NPE
    }

    public static Optional<Double> average(int... scores) {

        if (scores.length == 0)
            return Optional.empty();

        int sum = 0;
        for (int score : scores)
            sum += score;

        return Optional.of((double) sum / scores.length);
    }
}
