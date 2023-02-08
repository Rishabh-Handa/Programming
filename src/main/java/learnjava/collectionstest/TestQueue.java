package learnjava.collectionstest;

import java.util.*;

public class TestQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(2);
        q.add(4);
        q.add(7);
        q.add(3);

        System.out.println(q);
        q.remove(4);

        System.out.println(q);

        Queue<Integer> q1 = new PriorityQueue<>(Collections.reverseOrder());

        Map<Integer, String> myMap = new HashMap<>();

        String whatIs = myMap.put(3,"hello");
        String whatIs2 = myMap.put(3,"hello1");
    }
}
