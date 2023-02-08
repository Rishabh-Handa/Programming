package epam;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ToMap {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);

        AtomicInteger i = new AtomicInteger();
        Map<Integer, Integer> map = list.stream().collect(Collectors.toMap(k -> i.getAndIncrement(), k -> k));

        System.out.println(map);
    }
}
