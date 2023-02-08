package patterns.mergeInterval;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given a list of intervals, merge all the overlapping
 * intervals to produce a list that has only mutually exclusive intervals.
 *
 * Example 1:
 *
 * Intervals: [[1,4], [2,5], [7,9]]
 * Output: [[1,5], [7,9]]
 * Explanation: Since the first two intervals [1,4] and [2,5] overlap, we merged them into
 * one [1,5].
 */
public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        List<List<Integer>> intervals = Arrays.asList( Arrays.asList(1,4), Arrays.asList(2,5), Arrays.asList(7,9));
        System.out.println(mergeIntervals(intervals));

        System.out.println(mergeIntervals(Arrays.asList(Arrays.asList(6,7), Arrays.asList(2,4), Arrays.asList(5,9))));

        System.out.println(mergeIntervals(Arrays.asList( Arrays.asList(1,4), Arrays.asList(2,6), Arrays.asList(3,5))));
    }

    private static List<List<Integer>> mergeIntervals(List<List<Integer>> intervals) {
        intervals.sort((a,b) -> a.get(0) - b.get(0));
        Queue<List<Integer>> queue = new PriorityQueue<>((a,b) -> b.get(1) - a.get(1));

        for(List<Integer> interval: intervals) {
            if(queue.isEmpty()) {
                queue.add(interval);
            } else {
                int start = interval.get(0);
                List<Integer> head = queue.peek();
                int end = head.get(1);

                if(start < end) {
                    queue.poll();
                    end = interval.get(1) > head.get(1) ? interval.get(1) : head.get(1);
                    queue.add(Arrays.asList(head.get(0), end));
                } else {
                    queue.add(interval);
                }
            }
        }

        return new ArrayList<>(queue);
    }
}
