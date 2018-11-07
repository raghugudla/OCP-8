package izo809.chap6;

import java.io.IOException;

public class MutliExceptionTest {

    public static void main(String... s) {
        try {
            method2();
        } catch (Exception e) {
            e.printStackTrace();
            for (Throwable throwable : e.getSuppressed())
                System.out.println("throwable = " + throwable);
        }
    }

    private static void method2() throws Exception {
        try {
            method1();
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            throw new IOException();
        }
    }

    private static void method1() {
        throw new RuntimeException();
    }
}
