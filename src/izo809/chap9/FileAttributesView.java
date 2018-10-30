package izo809.chap9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.*;

public class FileAttributesView {

    public static void withBasicAttribues() throws IOException {
        Path path = Paths.get("./src/izo809");
        BasicFileAttributes data = Files.readAttributes(path, BasicFileAttributes.class);
        System.out.println("Is path a directory? " + data.isDirectory());
        System.out.println("Is path a regular file? " + data.isRegularFile());
        System.out.println("Is path a symbolic link? " + data.isSymbolicLink());
        System.out.println("Path not a file, directory, nor symbolic link? " + data.isOther());
        System.out.println("Size (in bytes): " + data.size());
        System.out.println("Creation date/time: " + data.creationTime());
        System.out.println("Last modified date/time: " + data.lastModifiedTime());
        System.out.println("Last accessed date/time: " + data.lastAccessTime());
        System.out.println("Unique file identifier (if available): " + data.fileKey());
        System.out.println();
    }

    public static void withDosFileAttributes() throws IOException {
        Path path = Paths.get("./src/izo809");
        DosFileAttributes data = Files.readAttributes(path, DosFileAttributes.class);
        System.out.println("Is path a directory? " + data.isDirectory());
        System.out.println("Is path a regular file? " + data.isRegularFile());
        System.out.println("Is path a symbolic link? " + data.isSymbolicLink());
        System.out.println("Path not a file, directory, nor symbolic link? " + data.isOther());
        System.out.println("Size (in bytes): " + data.size());
        System.out.println("Creation date/time: " + data.creationTime());
        System.out.println("Last modified date/time: " + data.lastModifiedTime());
        System.out.println("Last accessed date/time: " + data.lastAccessTime());
        System.out.println("Unique file identifier (if available): " + data.fileKey());
        System.out.println();
    }

    public static void withPosixFileAttributes() throws IOException {
        Path path = Paths.get("./src/izo809");
        PosixFileAttributes data = Files.readAttributes(path, PosixFileAttributes.class);
        System.out.println("Is path a directory? " + data.isDirectory());
        System.out.println("Is path a regular file? " + data.isRegularFile());
        System.out.println("Is path a symbolic link? " + data.isSymbolicLink());
        System.out.println("Path not a file, directory, nor symbolic link? " + data.isOther());
        System.out.println("Size (in bytes): " + data.size());
        System.out.println("Creation date/time: " + data.creationTime());
        System.out.println("Last modified date/time: " + data.lastModifiedTime());
        System.out.println("Last accessed date/time: " + data.lastAccessTime());
        System.out.println("Unique file identifier (if available): " + data.fileKey());
        System.out.println();
    }

    public static void withBasicView() throws IOException {
        Path path = Paths.get("./src/izo809/chap9/FileAttributesEx.java");
        BasicFileAttributeView view =
                Files.getFileAttributeView(path, BasicFileAttributeView.class);
        BasicFileAttributes data = view.readAttributes();

        FileTime lastModifiedTime = data.lastModifiedTime();
        System.out.println("lastModifiedTime " + lastModifiedTime);

        lastModifiedTime = FileTime.fromMillis(lastModifiedTime.toMillis() + 10_000);
        System.out.println("lastModifiedTime " + lastModifiedTime);

        view.setTimes(null, null, null);
    }

    public static void main(String[] args) throws IOException {
		/*
		withBasicAttribues();
		withDosFileAttributes();
		withPosixFileAttributes();
		*/
        withBasicView();
    }

}
