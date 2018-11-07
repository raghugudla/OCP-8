package izo809.chap9;

import java.io.IOException;
import java.nio.file.Paths;

public class PathsTest {

    public static void main(String... a) throws IOException {
        System.out.println("Paths.get(\"./my-dir/..\").normalize() = "
                + Paths.get("./my-dir/..").normalize());

        System.out.println("Paths.get(\"./my-dir/..\").toAbsolutePath() = "
                + Paths.get("./my-dir/..").toAbsolutePath());

        System.out.println("Paths.get(\"./my-dir/..\").toAbsolutePath() = "
                + Paths.get("./src/..").toRealPath());

        System.out.println("Paths.get(\"./my-dir/..\").toAbsolutePath() = "
                + Paths.get("C:/./project/../../src/main/resources/config.xml").toAbsolutePath());
    }
}
