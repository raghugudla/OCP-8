package izo809.chap6;

import java.io.IOException;

public class SpecialExc {

    public static void main(String[] args) {

        try {

            new SpecialExc().run();

        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    void run() throws IOException { /* throwing IOExc after catching it as Exception.*/

        try (SomeConn conn = new SomeConn()) {

            throw new IOException();

        } catch (Exception e) {

            throw e;
        }
    }

    class SomeConn implements AutoCloseable {

        @Override
        public void close() {

            throw new RuntimeException();

        }

    }
}
