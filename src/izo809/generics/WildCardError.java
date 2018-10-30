package izo809.generics;

import java.util.List;

public class WildCardError {

    static void foo(List<?> i) {
        //i.set(0, i.get(0)); // error
        fooHelper(i);
    }

    // Helper method created so that the wildcard can be captured
    // through type inference.
    static  <T> void fooHelper(List<T> l) {
        l.set(0, l.get(0));
    }

    static void swapFirst(List<? extends Number> l1, List<? extends Number> l2) {
        Number temp = l1.get(0);
        //l1.set(0, l2.get(0)); // expected a CAP#1 extends Number,
        // got a CAP#2 extends Number;
        // same bound, but different types

        //l2.set(0, temp);	    // expected a CAP#1 extends Number,
        // got a Number

        /*
        List<Integer> li = Arrays.asList(1, 2, 3);
        List<Double>  ld = Arrays.asList(10.10, 20.20, 30.30);
        swapFirst(li, ld);
         */
    }
}
