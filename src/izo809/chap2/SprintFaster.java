package izo809.chap2;

@FunctionalInterface
public interface SprintFaster extends Sprint {
    void sprint(Animal animal);
    //default void sprint(Animal animal) {}
    //static void sprint(Animal animal) {}
}
