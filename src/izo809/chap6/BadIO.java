package izo809.chap6;

import java.io.IOException;
import java.sql.SQLException;

public class BadIO {

    public static void main(String[] args) {
        BadIO bad = new BadIO();

        try {

            //bad.fileBlowUp();
            bad.dbBlowUp();

        } catch (Exception e) {

            e.printStackTrace();

            Throwable[] throwables = e.getSuppressed();
            for (Throwable t : throwables)
                System.out.println("t = " + t);
        }

    }

    void dbBlowUp() {
        try {
            throw new SQLException();
        } finally {
            throw new RuntimeException();
        }
    }

    void fileBlowUp() throws IOException {
        throw new IOException();
    }

}
