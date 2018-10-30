package izo809.chap6;

import java.io.IOException;
import java.sql.SQLException;

public class BadIO {

    public static void main(String[] args) {
        BadIO bad = new BadIO();

        try {

            bad.fileBlowUp();
            bad.dbBlowUp();

        } catch (IOException e) {

            e.printStackTrace();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    void dbBlowUp() throws SQLException {
        throw new SQLException();
    }

    void fileBlowUp() throws IOException {
        throw new IOException();
    }

}
