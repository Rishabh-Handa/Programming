package learnjava.collectionstest;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class TestMap {
    public static void main(String[] args) throws InterruptedException {
       // weakHashMap();
        treemap();
    }

    private static void weakHashMap() throws InterruptedException {
        Map<String, Integer> hashmap = new HashMap<>();

        Map<String, Integer> weakHashmap = new WeakHashMap<>();

        String a = new String("one");
        String b = new String("two");

        hashmap.put(a, 1);
        hashmap.put(b, 2);

        weakHashmap.put(a, 1);
        weakHashmap.put(b, 2);

        System.out.println(hashmap);
        System.out.println(weakHashmap);

        a = null;
        System.gc();

        Thread.sleep(3000);
        System.out.println(hashmap);
        System.out.println(weakHashmap);
    }


    static void concurrentMap() {
        ConcurrentHashMap<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();
    }
    static void treemap() {
        TreeMap<Integer, String> treeMap = new TreeMap<>();


        treeMap.put(1, "one");
        treeMap.put(5, "three");
        treeMap.put(4, "four");
        treeMap.put(2, "two");

        System.out.println(treeMap);

        //head
        System.out.println("head");
        System.out.println(treeMap.headMap(4));
        System.out.println(treeMap.headMap(4, true));
        System.out.println(treeMap.headMap(3));

        //tail
        System.out.println("tail");
        System.out.println(treeMap.tailMap(2));
        System.out.println(treeMap.tailMap(2, false));
        System.out.println(treeMap.tailMap(3));
    }
}
