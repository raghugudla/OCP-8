package izo809.chap6;

import java.io.IOException;

public class WeiredExceptionHandling {

    public static void main(String[] a) {
        try {
            throw new IOException();
        } catch (IOException e) {
            e = (IOException) new Exception();
            e.printStackTrace();
        }
    }
}
