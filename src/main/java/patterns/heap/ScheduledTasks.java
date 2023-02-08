package patterns.heap;

import java.util.*;

/**
 * You are given a list of tasks that need to be run, in any order, on a server.
 * Each task will take one CPU interval to execute but once a task has finished,
 * it has a cooling period during which it can’t be run again.
 * If the cooling period for all tasks is ‘K’ intervals, find the minimum number of CPU intervals that
 * the server needs to finish all tasks.
 *
 * If at any time the server can’t execute any task then it must stay idle.
 *
 * Example 1:
 *
 * Input: [a, a, a, b, c, c], K=2
 * Output: 7
 * Explanation: a -> c -> b -> a -> c -> idle -> a
 */
public class ScheduledTasks {
    public static void main(String[] args) {
        System.out.println(rearrange("aaabcc", 2));
        System.out.println(rearrange("aba", 3));
    }

    private static int rearrange(String str, int k) {
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


        Queue<Character> queue = new LinkedList<>();
        int count = 0;

        while(!freq.isEmpty()) {
            char ch = !maxHeap.isEmpty() ? maxHeap.poll() : 0;
            int f = freq.getOrDefault(ch, 0) - 1;

            if(ch != 0) {
                freq.put(ch, f);
            }


            sb.append(ch);

            queue.offer(ch);

            if(queue.size() == k + 1) {
                char currCh = queue.poll();
                if(freq.getOrDefault(currCh, 0) >= 1) {
                    maxHeap.offer(currCh);
                }
            }

            if(f == 0) {
                freq.remove(ch);
            }
            count++;
        }



        return count;
    }
}
