package test.code;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JoinArray {

    public static void main(String[] args) {
        List<String> hello = Arrays.asList("a", "b", "c");

        String h = hello.stream().collect(Collectors.joining(","));

        System.out.println(h);
    }
}
