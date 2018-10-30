package izo809.chap8;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BufferedReaderWriter {

    public static List<String> readFile(File source) throws IOException {
        List<String> data = new ArrayList<String>();
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String s;
            while ((s = reader.readLine()) != null) {
                data.add(s);
            }
        }
        return data;
    }

    public static void writeFile(List<String> data, File destination) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
            for (String s : data) {
                writer.write(s);
                writer.newLine();
            }
        }
    }

    public static void copyFile(File source, File destination) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                writer.write(line);
                // writer.newLine() method to insert a line break into the copied file, as our
                // reader.readLine() method split on line breaks.
                writer.newLine();
            }

        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("started at : " + LocalDateTime.now());

        File source = new File("C:\\software\\temp.txt");
        File destination = new File("C:\\software\\temp_copy.txt");
/*
		List<String> data = readFile(source);
		for (String record : data) {
			System.out.println(record);
		}
		writeFile(data, destination);
*/
        copyFile(source, destination);

        System.out.println("done at : " + LocalDateTime.now());
    }

}
