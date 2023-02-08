package patterns.heap;

import java.util.*;

/**
 * Given a string, find if its letters can be rearranged in such a way
 * that no two same characters come next to each other.
 *
 * Example 1:
 *
 * Input: "aappp"
 * Output: "papap"
 * Explanation: In "papap", none of the repeating characters come next to each other.
 */
public class RearrangeString {
    public static void main(String[] args) {
        System.out.println(rearrange("aappp"));
        System.out.println(rearrange("Programming"));
        System.out.println(rearrange("aapa"));
    }

    private static String rearrange(String str) {
        Map<Character, Integer> freq = new HashMap<>();
        char[] chars = str.toCharArray();

        for(char chare: chars) {
            freq.put(chare, freq.getOrDefault(chare, 0) + 1);
        }

        Queue<Character> maxHeap = new PriorityQueue<>((a,b) -> freq.get(b) - freq.get(a));

        for(char chare: freq.keySet()) {
            maxHeap.offer(chare);
        }

        char[] result = new char[str.length()];
        int index = 0;

        char cached = 0;

        while(!maxHeap.isEmpty()) {
            char ch = maxHeap.poll();
            int f = freq.get(ch) - 1;
            freq.put(ch, f);


            result[index++] = ch;

            if(cached != 0) {
                maxHeap.offer(cached);
            }

            if(f > 0) {
                cached = ch;
            } else {
                cached = 0;
            }
        }

        if(cached != 0) {
            return "";
        }

        return new String(result);
    }
}
