package puzzle;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HighestNumberFrequency {
    public static void main(String[] args) {
        String str = "aaabfferxggxghaxx";

        Map<Character, Integer> map = new HashMap<>();

        char[] chars = str.toCharArray();
        for(char ch: chars) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        System.out.println(map);
        String result = map.values()
                .stream().distinct()
                .sorted(Collections.reverseOrder())
                .map(Object::toString).collect(Collectors.joining());

        System.out.println(result);
    }
}
