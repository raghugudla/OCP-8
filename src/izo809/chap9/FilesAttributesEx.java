package izo809.chap9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.time.Instant;

public class FilesAttributesEx {

    private static void commonAttributes() {
        // If dir not exist no exception thrown
        System.out.println("isDirectory " + Files.isDirectory(Paths.get("/canine/coyote/fur.jpg")));
        System.out.println("isRegularFile " + Files.isRegularFile(Paths.get("/canine/types.txt")));
        System.out.println("isSymbolicLink " + Files.isSymbolicLink(Paths.get("/canine/coyote")));
        System.out.println();

        System.out.println(Paths.get(".") + " isDirectory " + Files.isDirectory(Paths.get(".")));
        System.out.println(Paths.get(".") + " isRegularFile " + Files.isRegularFile(Paths.get(".")));
        System.out.println(Paths.get(".") + " isSymbolicLink " + Files.isSymbolicLink(Paths.get("./src")));
        System.out.println();
    }

    private static void advancedAttributes() throws IOException {
        // isHidden() throws exception if file/dir not found
        System.out.println("isReadable " + Files.isReadable(Paths.get("/canine/types.txt")));
        System.out.println("isExecutable " + Files.isExecutable(Paths.get("/canine/coyote")));
        System.out.println();

        System.out.println(Paths.get(".") + " isHidden " + Files.isHidden(Paths.get(".")));
        System.out.println(Paths.get(".") + " isReadable " + Files.isReadable(Paths.get(".")));
        System.out.println(Paths.get(".") + " isExecutable " + Files.isExecutable(Paths.get("./src")));
        System.out.println();

        // throws IOException
        System.out.println(Files.size(Paths.get(".")));
        System.out.println(Files.size(Paths.get("./src")));
        System.out.println();
    }

    private static void modifiedTime() throws IOException {
        final Path path = Paths.get("./src/izo809/chap9/FilesAttributesEx.java");
        System.out.println("1.LastModifiedTime " + Files.getLastModifiedTime(path));
        System.out.println("2.LastModifiedTime " + Files.getLastModifiedTime(path).toMillis());
        Files.setLastModifiedTime(path, FileTime.from(Instant.now()));
        System.out.println("3.LastModifiedTime " + Files.getLastModifiedTime(path));
        System.out.println("4.LastModifiedTime " + Files.getLastModifiedTime(path).toMillis());
        System.out.println();
    }

    private static void owner() throws IOException {
        final Path path = Paths.get("src/izo809/chap9/FilesAttributesEx.java");
        System.out.println("owner " + Files.getOwner(path));
        System.out.println("owner name " + Files.getOwner(path).getName());
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
		commonAttributes();
		advancedAttributes();
		modifiedTime();
        /*
		 * */
        owner();
    }

}
