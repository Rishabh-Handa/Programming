package learnjava.collectionstest;

import java.util.HashSet;
import java.util.Set;

public class TestHashSet {
    public static void main(String[] args) {
        testHashSet();
    }

    static void testHashSet() {
        HashSet<Integer> set = new HashSet<>();
        set.add(2);set.add(3);set.add(4);
        HashSet<Integer> set2 = new HashSet<>();
        set2.add(7);set2.add(4);set2.add(9);

        set.retainAll(set2);
        set2.retainAll(set);

        System.out.println(set);
        System.out.println(set2);
    }
}
