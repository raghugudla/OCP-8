package izo809.chap3.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MethodReferences {

    public static void main(String[] args) {
    }

    public static void staticMethodRef() {
        Comparator<Duck> comparator1 = (d1, d2) -> d1.getWeight() - d2.getWeight();
        Comparator<Duck> comparator2 = (d1, d2) -> DuckHelper.compareByWeight(d1, d2);
        Comparator<Duck> comparator3 = DuckHelper::compareByWeight;

        Consumer<List<Integer>> lambda = l -> Collections.sort(l);
        Consumer<List<Integer>> methodRef = Collections::sort;
    }

    public static void instanceMethodRef() {
        String str = "abc"; //particular instance
        Predicate<String> lambda = s -> str.startsWith(s);
        Predicate<String> methodRef = str::startsWith; //particular instance str is used
    }

    public static void runtimeInstanceMethodRef() {
        Predicate<String> lambda = s -> s.isEmpty();
        Predicate<String> methodRef = String::isEmpty;
    }

    public static void constructorMethodRef() {
        Supplier<ArrayList<String>> lambda = () -> new ArrayList<>();
        Supplier<ArrayList<String>> methodRef = ArrayList::new;
    }
}
