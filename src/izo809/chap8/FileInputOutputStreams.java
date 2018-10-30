package izo809.chap8;

import java.io.*;
import java.time.LocalDateTime;

public class FileInputOutputStreams {

    public static void copy(File source, File destination) throws IOException {
        try (InputStream in = new FileInputStream(source); OutputStream out = new FileOutputStream(destination)) {
            int b;
            while ((b = in.read()) != -1) {
                out.write(b);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("started at : " + LocalDateTime.now());

        File source = new File("C:\\software\\temp.txt");
        File destination = new File("C:\\software\\temp_copy.txt");
        copy(source, destination);

        System.out.println("done at : " + LocalDateTime.now());
    }

}
