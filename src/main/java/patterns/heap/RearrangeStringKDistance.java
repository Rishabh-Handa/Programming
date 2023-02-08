package patterns.heap;

import java.util.*;

/**
 * Given a string and a number ‘K’, find if the string can be rearranged such that
 * the same characters are at least ‘K’ distance apart from each other.
 *
 * Example 1:
 *
 * Input: "mmpp", K=2
 * Output: "mpmp" or "pmpm"
 * Explanation: All same characters are 2 distance apart.
 */
public class RearrangeStringKDistance {
    public static void main(String[] args) {
        System.out.println(rearrange("aappp", 2));
        System.out.println(rearrange("Programming", 3));
        System.out.println(rearrange("aappa", 3));
        System.out.println(rearrange("aab", 2));
    }

    private static String rearrange(String str, int k) {
        Map<Character, Integer> freq = new HashMap<>();
        char[] chars = str.toCharArray();

        for(char chare: chars) {
            freq.put(chare, freq.getOrDefault(chare, 0) + 1);
        }

        Queue<Character> maxHeap = new PriorityQueue<>((a, b) -> freq.get(b) - freq.get(a));

        for(char chare: freq.keySet()) {
            maxHeap.offer(chare);
        }

        StringBuilder sb = new StringBuilder();

        int index = 0;

        Queue<Character> queue = new LinkedList<>();

        while(!maxHeap.isEmpty()) {
            char ch = maxHeap.poll();
            int f = freq.get(ch) - 1;
            freq.put(ch, f);


            sb.append(ch);

            queue.offer(ch);

            if(queue.size() == k) {
                char currCh = queue.poll();
                if(freq.get(currCh) >= 1) {
                    maxHeap.offer(currCh);
                }
            }
        }



        return str.length() == sb.length() ? sb.toString() : "";
    }
}
