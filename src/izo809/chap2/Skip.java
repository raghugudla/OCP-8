package izo809.chap2;

@FunctionalInterface
public interface Skip extends Sprint {
    default void skip(int speed) {
    }
}
