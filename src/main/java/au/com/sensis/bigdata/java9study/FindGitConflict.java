package au.com.sensis.bigdata.java9study;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FindGitConflict {

    public static void main(String[] args) throws IOException {

        // Files.lines -> Stream<String>
        Files.lines(Paths.get("src/main/resources/index.html"))
                .dropWhile(line->!line.contains("<<<<<<<"))
                .skip(1)
                .takeWhile(line->!line.contains(">>>>>>>"))
                .forEach(System.out::println);

    }

}
