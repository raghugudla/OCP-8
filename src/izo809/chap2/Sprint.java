package izo809.chap2;

@FunctionalInterface
public interface Sprint {

    static void test(String animal) {
        System.out.println("static method in functional interface...");
    }

    static void test3(String animal) {
        System.out.println("functional interface can have any number of static methods...");
    }

    void sprint(Animal animal);

    default void test1(String animal) {
        System.out.println("default method is not static and can be allowed in functional interface...");
    }

    default void test2(String animal) {
        System.out.println("functional interface can have any number of default methods...");
    }

}