package patterns.mergeInterval;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given a list of intervals representing the start and end time of ‘N’ meetings,
 * find the minimum number of rooms required to hold all the meetings.
 *
 * Example 1:
 *
 * Meetings: [[1,4], [2,5], [7,9]]
 * Output: 2
 * Explanation: Since [1,4] and [2,5] overlap, we need two rooms to hold these two meetings. [7,9] can
 * occur in any of the two rooms later.
 */
public class MinimumMeetingRoomsRequired {
    public static void main(String[] args) {
        System.out.println(findNoMR(new int[][]{{1,4}, {2,5}, {7,9}}));

        System.out.println(findNoMR(new int[][]{{6,7}, {2,4}, {8,12}}));

        System.out.println(findNoMR(new int[][]{{1,4}, {2,3}, {3,6}}));

        System.out.println(findNoMR(new int[][]{{4,5}, {2,3}, {2,4}, {3,5}}));
    }

    private static int findNoMR(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        Queue<Integer> queue = new PriorityQueue<>();

        for(int[] interval: intervals) {
            if(!queue.isEmpty() && interval[0] >= queue.peek()) {
                queue.poll();
            }
            queue.add(interval[1]);
        }

        return queue.size();
    }
}
