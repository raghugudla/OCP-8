package izo809.chap2;

//@FunctionalInterface
public interface Run extends Sprint {
    default void sprint(Animal animal) {
    }
    //static void sprint(Animal animal) {}
}
