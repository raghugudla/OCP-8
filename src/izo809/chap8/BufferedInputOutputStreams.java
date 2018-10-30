package izo809.chap8;

import java.io.*;
import java.time.LocalDateTime;

public class BufferedInputOutputStreams {

    public static void copy(File source, File destination) throws IOException {
        try (InputStream in = new BufferedInputStream(new FileInputStream(source));
             OutputStream out = new BufferedOutputStream(new FileOutputStream(destination))) {
            byte[] buffer = new byte[1024];
            int lengthRead;
            while ((lengthRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, lengthRead);
                out.flush();
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
