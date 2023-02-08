package patterns.mergeInterval;

import java.util.Arrays;

/**
 * Given an array of intervals representing ‘N’ appointments, find out if a person can attend all the appointments.
 *
 * Example 1:
 *
 * Appointments: [[1,4], [2,5], [7,9]]
 * Output: false
 * Explanation: Since [1,4] and [2,5] overlap, a person cannot attend both of these appointments.
 */
public class AppointmentConflict {
    public static void main(String[] args) {
        System.out.println(findConflict(new int[][]{{1,4}, {2,5}, {7,9}}));
        System.out.println(findConflict(new int[][]{{6,7}, {2,4}, {8,12}}));
        System.out.println(findConflict(new int[][]{{4,5}, {2,3}, {3,6}}));
    }

    private static boolean findConflict(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        for(int i=0; i<intervals.length - 1; i++) {
            if(intervals[i][1] > intervals[i+1][0]) {
                return false;
            }
        }

        return true;
    }
}
