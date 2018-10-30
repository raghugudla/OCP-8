package izo809.generics;

import java.util.ArrayList;
import java.util.List;

public class Car extends Vehicle {

    private static Car car = new Car();
    private static Vehicle vehicle = new Vehicle();

    public static void main(String[] args) {
        List<? extends Vehicle> list1 = new ArrayList<>();
        List<? super Vehicle> list2 = new ArrayList<>();

        //list1.add();

        list2.add(vehicle);
        list2.add(car);
    }

    private static void meth1(List<? extends Vehicle> list) {
        for(Vehicle v: list)
            System.out.println("vehicle = " + v);
    }

    private static void meth2(List<? super Vehicle> list) {
        list.add(car);
        list.add(vehicle);
    }

    private static void meth3(List<? extends Number> list) {
        for(Number n: list)
            n.byteValue();
    }

    private static void meth4(List<? super Number> list) {
        list.add(1);
        list.add(1.0);
    }
}
