package izo809.chap4;

import java.util.ArrayList;
import java.util.function.Supplier;

public class SupplierTest {

    public static void main(String[] args) {
        Supplier<ArrayList<String>> methodRef = ArrayList::new;
        Supplier<ArrayList<String>> lambda = () -> new ArrayList<>();

        System.out.println("methodRef.get() : " + methodRef.get());
        System.out.println("lambda.get() : " + lambda.get());
    }

}
