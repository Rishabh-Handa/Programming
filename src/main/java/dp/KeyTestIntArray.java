package dp;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class KeyTestIntArray {

    static class Pair {
        int key;
        int val;

        Pair(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public int hashCode() {
            return Objects.hash(key, val);
        }

        public boolean equals(Object o) {
            Pair pair = (Pair) o;
            return pair.key == key && pair.val == val;
        }

    }
    public static void main(String[] args) {
        Pair one = new Pair(1,2);
        Pair two = new Pair(1,2);

        Map<Pair, Integer> map = new HashMap<>();

        map.put(one, 1);
        map.put(two, 2);



        System.out.println(map);
    }
}
