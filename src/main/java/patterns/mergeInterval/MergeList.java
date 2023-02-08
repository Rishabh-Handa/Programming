package patterns.mergeInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given two lists of intervals, find the intersection of these two lists.
 * Each list consists of disjoint intervals sorted on their start time.
 *
 * Example 1:
 *
 * Input: arr1=[[1, 3], [5, 6], [7, 9]], arr2=[[2, 3], [5, 7]]
 * Output: [2, 3], [5, 6], [7, 7]
 * Explanation: The output list contains the common intervals between the two lists.
 */
public class MergeList {
    public static void main(String[] args) {
        int[][] result = getMergedInterval(new int[][]{{1,3}, {5,6}, {7,9}}, new int[][]{{2,3}, {5,7}});
        Arrays.stream(result).forEach(i -> System.out.print("["+i[0] + "," + i[1] +"]"));
        System.out.println();

        result = getMergedInterval(new int[][]{{1,3}, {5,7}, {9,12}}, new int[][]{{5,10}});
        Arrays.stream(result).forEach(i -> System.out.print("["+i[0] + "," + i[1] +"]"));
        System.out.println();
    }

    private static int[][] getMergedInterval(int[][] arr1, int[][] arr2) {
        List<int[]> result = new ArrayList<>();
        int i=0, j=0;
        while(i<arr1.length && j<arr2.length) {
            int[] earr2 = arr2[j];
            int[] earr1 = arr1[i];
            if((earr2[0] >= earr1[0] && earr2[0] <= earr1[1]) || (earr1[0] >= earr2[0] && earr1[0] <= earr2[1])) {
                int left = Math.max(earr1[0], earr2[0]);
                int right = Math.min(earr1[1], earr2[1]);
                result.add(new int[]{left, right});
            }

            if(earr1[1] < earr2[1]) {
                i++;
            } else {
                j++;
            }

        }
        return result.toArray(new int[result.size()][]);
    }
}
