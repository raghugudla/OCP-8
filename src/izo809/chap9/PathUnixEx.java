package izo809.chap9;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathUnixEx {

    private static void io_uri() {
        Path path = Paths.get("temp.txt");
        System.out.println(path);
        System.out.println(path.toUri());
        System.out.println(path.toFile());
        System.out.println();
    }

    private static void nameCount() {
        // c: in windows, / in unix is ignored as root.
        // if you run the windows program in unix the root is treated as an element.

        Path path = Paths.get("/","/","/","software","temp.txt");
        System.out.println(path);

        for (int i = 0; i < path.getNameCount(); i++) {
            System.out.println(" Element " + i + " is: " + path.getName(i));
            System.out.println(" Element " + i + " is: " + path.getName(i).toAbsolutePath());
        }
        System.out.println();
    }

    private static void root_parent() {
        Path path = Paths.get("///src/main/java/package");
        System.out.println("Filename is: " + path.getFileName());
        System.out.println("Root is: " + path.getRoot());
        Path currentParent = path;
        while ((currentParent = currentParent.getParent()) != null) {
            System.out.println(" Current parent is: " + currentParent);
        }
        System.out.println();
    }

    private static void absolutePath() {
        Path path = Paths.get("src/izo809/chap9");

        System.out.println("isAbsolute " + path.isAbsolute());
        System.out.println("isAbsolutePath " + path.toAbsolutePath());

        path = Paths.get("software/temp.txt");
        System.out.println("isAbsolute " + path.isAbsolute());
        System.out.println("isAbsolutePath " + path.toAbsolutePath());
        System.out.println();
    }

    private static void realPath() {

        Path path = Paths.get("src/izo809/chap9");
        try {
            System.out.println("toRealPath " + path.toRealPath());

            System.out.println("present working dir " + Paths.get("."));
            System.out.println("present working dir real path " + Paths.get(".").toRealPath() + "\n");

            //path = Paths.get("/software/temp.txt");
            //System.out.println("toRealPath " + path.toRealPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
    }

    private static void subPath() {
        Path path = Paths.get("C:\\software\\temp.txt");
        System.out.println("Path is: " + path);
//        System.out.println("Subpath from 0 to 2 is: " + path.subpath(0, 2));
        System.out.println("Subpath from 0 to 1 is: " + path.subpath(0, 1));
        //System.out.println("Subpath from 1 to 2 is: " + path.subpath(1, 2));
        System.out.println();

        path = Paths.get("//mammal/carnivore/raccoon.image");
        System.out.println("Path is: " + path);
        System.out.println("Subpath from 0 to 3 is: " + path.subpath(0, 3));
        System.out.println("Subpath from 1 to 3 is: " + path.subpath(1, 3));
        System.out.println("Subpath from 1 to 2 is: " + path.subpath(1, 2));
        System.out.println();
    }

    private static void relativize() {
        Path path1 = Paths.get("fish.txt");
        Path path2 = Paths.get("birds.txt");
        System.out.println(path1.relativize(path2));
        System.out.println(path2.relativize(path1));
        System.out.println();

        Path path3 = Paths.get("/habitat");
        Path path4 = Paths.get("/sanctuary/raven");
        System.out.println(path3.relativize(path4));
        System.out.println(path4.relativize(path3));

        //Mixed absolute and relative, throws IllegalArgExc
        //System.out.println(path1.relativize(path4));
        System.out.println();
    }

    private static void resolve() {
        final Path path1 = Paths.get("/cats/../panther");
        final Path path2 = Paths.get("food");
        System.out.println("path1.resolve(path2): " + path1.resolve(path2));
        System.out.println("path2.resolve(path1): " + path2.resolve(path1));
        System.out.println();

        // two absolute paths resolve
        final Path path3 = Paths.get("/turkey/food");
        final Path path4 = Paths.get("/tiger/cage");
        System.out.println("path3.resolve(path4): " + path3.resolve(path4));
        System.out.println("path4.resolve(path3): " + path4.resolve(path3));
        System.out.println();

        // two relative paths resolve
        Path path5 = Paths.get("fish.txt");
        Path path6 = Paths.get("birds.txt");
        System.out.println("path5.resolve(path6): " + path5.resolve(path6));
        System.out.println("path6.resolve(path5): " + path6.resolve(path5));
        System.out.println();
    }

    private static void normalize() {
        Path path3 = Paths.get("/data");
        Path path4 = Paths.get("/user/home");
        Path relativePath34 = path3.relativize(path4);
        Path resolvedPath34 = path3.resolve(relativePath34);
        System.out.println("relativePath34: " + relativePath34);
        System.out.println("resolvedPath34: " + resolvedPath34);
        System.out.println("3 to 4: " + resolvedPath34.normalize());
        System.out.println();

        Path relativePath43 = path4.relativize(path3);
        Path resolvedPath43 = path4.resolve(relativePath43);
        System.out.println("relativePath43: " + relativePath43);
        System.out.println("resolvedPath43: " + resolvedPath43);
        System.out.println("4 to 3: " + resolvedPath43.normalize());
        System.out.println();
    }

    public static void main(String[] args) {

        io_uri();
        nameCount();
        root_parent();

		absolutePath();
		realPath(); // IOException
        subPath();

        relativize();
        resolve();
        normalize();
    }

}
