package izo809.chap2;

public interface Mother {
    static void statMeth() {
    }

    void meth();

    default void deMeth() {
    }

    void mixMeth();
}
