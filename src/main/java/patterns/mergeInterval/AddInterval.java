package patterns.mergeInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a list of non-overlapping intervals sorted by their start time,
 * insert a given interval at the correct position and merge all necessary intervals to produce a list that has only mutually exclusive intervals.
 *
 * Example 1:
 *
 * Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,6]
 * Output: [[1,3], [4,7], [8,12]]
 * Explanation: After insertion, since [4,6] overlaps with [5,7], we merged them into one [4,7].
 */
public class AddInterval {
    public static void main(String[] args) {
        int[][] response = getIntevals(new int[][]{{1,3}, {4,7}, {8,12}}, new int[] {4,6});
        Arrays.stream(response).forEach(i -> System.out.print("["+i[0] + "," + i[1] +"]"));

        System.out.println();
        response = getIntevals(new int[][]{{1,3}, {5,7}, {8,12}}, new int[] {4,10});
        Arrays.stream(response).forEach(i -> System.out.print("["+i[0] + "," + i[1] +"]"));

        System.out.println();
        response = getIntevals(new int[][]{{2,3}, {5,7}}, new int[] {1,4});
        Arrays.stream(response).forEach(i -> System.out.print("["+i[0] + "," + i[1] +"]"));
    }

    private static int[][] getIntevals(int[][] nums, int[] interval) {
        List<int[]> result = new ArrayList<>();
        List<int[]> merge = new ArrayList<>();

        merge.add(interval);
        for(int[] num: nums) {
            if(num[0] <= interval[1] && num[1] >= interval[0]) {
                merge.add(num);
            } else {
                result.add(num);
            }
        }


        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int[] num: merge) {
            min = Math.min(min, num[0]);
            max = Math.max(max, num[1]);
        }

        result.add(new int[]{min, max});

        return result.toArray(new int[result.size()][]);
    }
}
