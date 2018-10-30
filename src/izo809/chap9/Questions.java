package izo809.chap9;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Questions {

    public static void q1() {
        Path path = Paths.get("/user/.././root", "../kodiacbear.txt");
        path.normalize().relativize(Paths.get("/lion"));
        System.out.println(path);
    }

    public static void q8() {
        Path path1 = Paths.get("/pets/../cat.txt");
        Path path2 = Paths.get("./dog.txt");
        System.out.println(path1.resolve(path2));
        System.out.println(path2.resolve(path1));
    }

    public static void main(String[] args) {
        q8();
    }

}
