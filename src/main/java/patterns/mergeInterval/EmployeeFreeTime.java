package patterns.mergeInterval;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * For ‘K’ employees, we are given a list of intervals representing the working hours of each employee. Our goal is to find out if there is a free interval that is common to all employees. You can assume that each list of employee working hours is sorted on the start time.
 *
 * Example 1:
 *
 * Input: Employee Working Hours=[[[1,3], [5,6]], [[2,3], [6,8]]]
 * Output: [3,5]
 * Explanation: Both the employess are free between [3,5].
 */
public class EmployeeFreeTime {
    public static void main(String[] args) {
        int[][] result = findFreeTime(new int[][]{{1,3}, {5,6}, {2,3}, {6,8}});
        Arrays.stream(result).forEach(i -> System.out.print("["+i[0] + "," + i[1] +"]"));
        System.out.println();

        result = findFreeTime(new int[][]{{1,3}, {9,12}, {2,4}, {6,8}});
        Arrays.stream(result).forEach(i -> System.out.print("["+i[0] + "," + i[1] +"]"));
        System.out.println();

        result = findFreeTime(new int[][]{{1,3}, {2,4}, {3,5}, {7,9}});
        Arrays.stream(result).forEach(i -> System.out.print("["+i[0] + "," + i[1] +"]"));
        System.out.println();
    }

    private static int[][] findFreeTime(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        if(intervals.length <= 1) {
            return null;
        }

        Queue<Integer> queue = new PriorityQueue<>();
        Stack<int[]> result = new Stack<>();

        int i = 0;

        for(int t=intervals[0][0]; t<intervals[intervals.length - 1][1]; t++) {
            while(!queue.isEmpty() && queue.peek() <= t) {
                queue.poll();
            }

            while(i<intervals.length && t == intervals[i][0]) {
                queue.offer(intervals[i][1]);
                i++;
            }

            if(queue.isEmpty()) {
                if(result.isEmpty() || result.peek()[1] < t) {
                    result.push(new int[]{t, t+1});
                } else {
                    int[] currI = result.peek();
                    currI[1] = t+1;
                }
            }
        }

        return result.toArray(new int[result.size()][]);

    }
}
