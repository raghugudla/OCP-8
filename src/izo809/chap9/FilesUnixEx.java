package izo809.chap9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.PosixFileAttributes;

public class FilesUnixEx {

    private static void exists() {
        Path path = Paths.get("/software/temp.txt");
        System.out.println(path + " exists ? " + Files.exists(path));

        Path relativePath = Paths.get("FilesEx.java");
        System.out.println(relativePath + " exists ? " + Files.exists(relativePath));

        relativePath = Paths.get("./src/izo809/chap9/FilesEx.java");
        System.out.println(relativePath + " exists ? " + Files.exists(relativePath));

        relativePath = Paths.get(".").relativize(relativePath);
        System.out.println(relativePath + " exists ? " + Files.exists(relativePath));
//		System.out.println(relativePath.toRealPath() + "\n");

        try {
            Path symbolicLink = Files.createSymbolicLink(Paths.get("out/aSyLink"), Paths.get("../src/izo809/chap999"));
            System.out.println("Files.exists(symbolicLink) default = " + Files.exists(symbolicLink));
            System.out.println("Files.exists(symbolicLink) = " + Files.exists(symbolicLink, LinkOption.NOFOLLOW_LINKS));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
    }

    private static void isSameFile() throws IOException {
        Path path1 = Paths.get("/git/OCP-1");
        System.out.println(path1 + " exists ? " + Files.exists(path1));

        Path path2 = Paths.get("/git/OCP-1");
        System.out.println(path2 + " exists ? " + Files.exists(path2));

        System.out.println("path1 isSameFile path2 " + Files.isSameFile(path1, path2));
//        System.out.println("path1 isSameFile currDir " + Files.isSameFile(path1, Paths.get(".")));
        System.out.println();

        System.out.println("symbol links isSameFile path2 " +
                Files.isSameFile(Paths.get("out/linkToChap9"), Paths.get("out/symbolicLinkToChap9")));

        System.out.println("symbol links isSameFile path2 " +
                Files.isSameFile(Paths.get("out/aSyLink"), Paths.get("out/symbolicLinkToChap9")));
    }

    private static void createDirectories() throws IOException {
        /*
         * RUN THIS METHOD MULTIPLE TIMES TO TEST AND UNDERSTAND
         * */
        try {
            Files.createDirectory(Paths.get("./out/nio/Files/createDirectory"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println();

            // createDirectories doesn't throw exception if its already exist
            Path dirs = Files.createDirectories(Paths.get("./out/nio/Files/createDirectories"));
            System.out.println("dirs = " + dirs);
        }
        System.out.println();
    }

    private static void createSymbolicLink() throws IOException {
        /*
         * RUN THIS METHOD MULTIPLE TIMES TO TEST AND UNDERSTAND
         * */
        Path symbolicLink = Files.createSymbolicLink(Paths.get("out/linkToChap9"), Paths.get("../src/izo809/chap9"));
        System.out.println("symbolicLink = " + symbolicLink);
        System.out.println();
    }

    /**
     * By default, copying files and directories will traverse symbolic links, although it
        will not overwrite a file or directory if it already exists, nor will it copy file attributes.
        These behaviors can be altered by providing the additional options NOFOLLOW_LINKS,
        REPLACE_EXISTING, and COPY_ATTRIBUTES, respectively
     */
    private static void copy() throws IOException {

        // 1. file copy
        Path fileCopy =
                Files.copy(Paths.get("notes/8_IO.txt"), Paths.get("out/nio/Files/note.txt"));
        printAttributes(fileCopy);

        // 2. file copy, can't overwrite by default!
        try {
            Files.copy(Paths.get("notes/9_NIO.txt"), Paths.get("out/nio/Files/note.txt"));
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println();

            fileCopy =
                    Files.copy(Paths.get("notes/9_NIO.txt"), Paths.get("out/nio/Files/note.txt"), StandardCopyOption.REPLACE_EXISTING);
            printAttributes(fileCopy);
        }

        //Observe the creationTime
        fileCopy =
                Files.copy(Paths.get("notes/Generics.txt"), Paths.get("out/nio/Files/Generics.txt"), StandardCopyOption.COPY_ATTRIBUTES);
        printAttributes(fileCopy);


        // 3. dir copy (shallow), dir also can't be over written!
        Files.copy(Paths.get("out/nio/Files"), Paths.get("out/nio/Files-Copy"));
    }

    private static void printAttributes(final Path path) throws IOException {
        System.out.println("path = " + path);
        PosixFileAttributes basicFileAttributes = Files.readAttributes(path, PosixFileAttributes.class);
        System.out.println("creationTime() = " + basicFileAttributes.creationTime());
        System.out.println("size() = " + basicFileAttributes.size());
        System.out.println();
    }

    /**
     * By default, the move() method will follow links, throw an exception if the fi
     * le already exists, and not perform an atomic move. These behaviors can be
     * changed by providing the optional values NOFOLLOW_LINKS , REPLACE_EXISTING ,
     * or ATOMIC_MOVE , respectively, to the method. If the fi le system does not
     * support atomic moves, an AtomicMoveNotSupportedException will be thrown at
     * runtime.
     */
    private static void move() throws IOException {
        // 1. dir move
        Files.move(Paths.get("out/nio/Files"), Paths.get("out/nio/Files-Move"));

        // 2. file move, can't over written
        Files.move(
                Paths.get("out/nio/Files-Move"),
                Paths.get("out/nio/Files-Copy"),
                StandardCopyOption.REPLACE_EXISTING,
                //StandardCopyOption.COPY_ATTRIBUTES, // UnsupportedOperationException
                StandardCopyOption.ATOMIC_MOVE
        );
    }

    private static void delete() throws IOException {

        // 1. delete dir
        try {
            Files.delete(Paths.get("src/some-folder"));
            System.out.println("this should never print!" );
        }
        catch (IOException e){
            //e.printStackTrace();
            System.out.println("failed to delete " + e.getMessage());
        }

        // 2. delete dir if it exists
        System.out.println("deleted: " + Files.deleteIfExists(Paths.get("src/some-folder")));

        // 3. Deletes symbolic link, not the target
        Path symbolicLink = Files.createSymbolicLink(Paths.get("out/linkToChap8"), Paths.get("../src/izo809/chap8"));
        System.out.println("symbolicLink = " + symbolicLink);
        System.out.println("Files.deleteIfExists(symbolicLink) = " + Files.deleteIfExists(symbolicLink));

        // 3 can't be deleted not empty dir by delete and deleteIfExists. throws
        // exception
        try {
            Files.delete(Paths.get("out/nio"));
            System.out.println("this should never print!" );
        }
        catch (IOException e){
            //e.printStackTrace();
            System.out.println("failed to delete " + e.getMessage());

            Files.deleteIfExists(Paths.get("out/nio"));
        }
    }

    private static void io() throws IOException {
        Path inPath = Paths.get("notes/9_NIO.txt");
        Path outPath = Paths.get("out/nio/9_NIO.txt");

        try (BufferedReader reader = Files.newBufferedReader(inPath, Charset.forName("UTF-8"));
             BufferedWriter writer = Files.newBufferedWriter(outPath, Charset.forName("UTF-16"))) {

            // Read from the stream
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {

                System.out.println(currentLine);
                writer.write(currentLine);
                writer.newLine();
            }
        }
    }

    public static void main(String[] args) throws IOException {

		//exists();
		//isSameFile();

		//createDirectories();
		//copy();
        //createSymbolicLink();
		//move();

        //delete();
        io();
    }

}
