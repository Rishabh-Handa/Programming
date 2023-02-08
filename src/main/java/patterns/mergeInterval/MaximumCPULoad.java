package patterns.mergeInterval;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * We are given a list of Jobs. Each job has a Start time, an End time,
 * and a CPU load when it is running. Our goal is to find the maximum CPU load
 * at any time if all the jobs are running on the same machine.
 *
 * Example 1:
 *
 * Jobs: [[1,4,3], [2,5,4], [7,9,6]]
 * Output: 7
 * Explanation: Since [1,4,3] and [2,5,4] overlap, their maximum CPU load (3+4=7) will be when both the
 * jobs are running at the same time i.e., during the time interval (2,4).
 */
public class MaximumCPULoad {
    public static void main(String[] args) {
        System.out.println(findMaxCPULoad(new int[][]{{1,4,3}, {2,5,4}, {7,9,6}}));

        System.out.println(findMaxCPULoad(new int[][]{{6,7,10}, {2,4,11}, {8,12,15}}));

        System.out.println(findMaxCPULoad(new int[][]{{1,4,2}, {2,4,1}, {3,6,5}}));

        System.out.println(findMaxCPULoad(new int[][]{{2,4,5}, {0,6,7}, {5,10,6}}));

        System.out.println(findMaxCPULoad(new int[][]{{2,4,5}, {0,6,7}, {5,10,6}, {0,3,10}}));
    }

    private static int findMaxCPULoad(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        if(intervals.length <= 0) {
            return 0;
        }
        int max = intervals[0][2];

        int currSum = intervals[0][2];

        Queue<int[]> queue = new PriorityQueue<>((a,b) -> a[1] - b[1]);


        for(int[] interval: intervals) {
            if(queue.isEmpty()) {
                queue.add(interval);
                continue;
            }
            while(!queue.isEmpty() && interval[0] > queue.peek()[1]) {
                int[] removedI = queue.poll();
                currSum -= removedI[2];
            }

            queue.add(interval);
            currSum += interval[2];

            max = Math.max(max, currSum);
        }
        return max;
    }
}
