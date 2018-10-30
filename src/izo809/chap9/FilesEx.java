package izo809.chap9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesEx {

    public static void exists() //throws IOException
    {
        Path path = Paths.get("C:\\software\\temp.txt");
        System.out.println(path + " exists ? " + Files.exists(path));

        Path relativePath = Paths.get("FilesEx.java");
        System.out.println(relativePath + " exists ? " + Files.exists(relativePath));

        relativePath = Paths.get("./src/izo809/chap9/FilesEx.java");
        System.out.println(relativePath + " exists ? " + Files.exists(relativePath));

        relativePath = Paths.get(".").relativize(relativePath);
        System.out.println(relativePath + " exists ? " + Files.exists(relativePath));
//		System.out.println(relativePath.toRealPath() + "\n");
        System.out.println();
    }

    public static void isSameFile() throws IOException {
        Path path1 = Paths.get("C:\\java\\workspace\\OCP-1");
        System.out.println(path1 + " exists ? " + Files.exists(path1));

        Path path2 = Paths.get("C:\\java\\workspace\\OCP-1");
        System.out.println(path2 + " exists ? " + Files.exists(path2));

        System.out.println("path1 isSameFile path2 " + Files.isSameFile(path1, path2));
        System.out.println("path1 isSameFile currDir " + Files.isSameFile(path1, Paths.get(".")));
        System.out.println();
    }

    public static void createDirectories() throws IOException {
        /*
         * RUN THIS METHOD MULTIPLE TIMES TO TEST AND UNDERSTAND
         * */
        try {
            Files.createDirectory(Paths.get("./src/test"));
        } catch (IOException e) {
            e.printStackTrace();
            // createDirectories doesn't throw exception if its already exist
            Files.createDirectories(Paths.get("./src/test/nio/dir/sub"));
        }
        System.out.println("done");
        System.out.println();
    }

    public static void copy() throws IOException {
        //Files.createFile(Paths.get("src/test/note.txt"));

        // 1. file copy
        Files.copy(Paths.get("./src/test/nio/dir/note.txt"), Paths.get("./src/test/nio/dir/sub/note.txt"));

        // 2. file copy, can't overwrite !
        Files.copy(Paths.get("./src/test/nio/dir/note.txt"), Paths.get("./src/test/nio/dir/sub/note.txt"));

        // 3. dir copy (shallow), dir also can't be over written!
        Files.copy(Paths.get("src/test"), Paths.get("src/test-save"));
		/*
		 * By default, copying files and directories will traverse symbolic links, although it
			will not overwrite a file or directory if it already exists, nor will it copy file attributes.
			These behaviors can be altered by providing the additional options NOFOLLOW_LINKS,
			REPLACE_EXISTING, and COPY_ATTRIBUTES, respectively
		 */
    }

    public static void move() throws IOException {
        // 1. dir move
        //Files.move(Paths.get("src/test"), Paths.get("src/test-save/test-move"));

        // 2. file move, can't over written
        Files.move(Paths.get("src/test-save/test-move/nio/dir/note.txt"),
                Paths.get("src/test-save/test-move/nio/dir/sub/note3.txt"));
        /*
         * By default, the move() method will follow links, throw an exception if the fi
         * le already exists, and not perform an atomic move. These behaviors can be
         * changed by providing the optional values NOFOLLOW_LINKS , REPLACE_EXISTING ,
         * or ATOMIC_MOVE , respectively, to the method. If the fi le system does not
         * support atomic moves, an AtomicMoveNotSupportedException will be thrown at
         * runtime.
         */
    }

    public static void delete() throws IOException {

        // 1. delete dir if it exists
        System.out.println("deleted: " + Files.deleteIfExists(Paths.get("src/some-folder")));

        // 2. can't be deleted not empty dir by delete and deleteIfExists. throws
        // exception
        Files.deleteIfExists(Paths.get("src/test-save"));
    }

    public static void io() throws IOException {
        Path inPath = Paths.get("src/test-save/test-move/sub-dir/note.txt");
        Path outPath = Paths.get("src/test-save/test-move/sub-dir/note3.txt");
        try (BufferedReader reader = Files.newBufferedReader(inPath, Charset.forName("US-ASCII"));
             BufferedWriter writer = Files.newBufferedWriter(outPath, Charset.forName("UTF-16"))) {
            // Read from the stream
            String currentLine = null;
            while ((currentLine = reader.readLine()) != null) {
                System.out.println(currentLine);
                writer.write(currentLine);
                writer.newLine();
            }
        }
    }

    public static void main(String[] args) throws IOException {
/*
		exists();
		isSameFile();

		createDirectories();
		copy();
		move();
*/
        delete();
        //io();
    }

}
