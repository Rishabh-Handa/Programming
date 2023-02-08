package patterns.heap;

import java.util.*;

/**
 * Given an array of points in the a 2D2D plane, find ‘K’ closest points to the origin.
 *
 * Example 1:
 *
 * Input: points = [[1,2],[1,3]], K = 1
 * Output: [[1,2]]
 * Explanation: The Euclidean distance between (1, 2) and the origin is sqrt(5).
 * The Euclidean distance between (1, 3) and the origin is sqrt(10).
 * Since sqrt(5) < sqrt(10), therefore (1, 2) is closer to the origin.
 */
public class NearToOrigin {

    public static void main(String[] args) {
        int[][] matrix = {{1,2}, {1,3}};
        System.out.println(findMinDistance(matrix, 1));

        int[][] matrix2 = {{1,3}, {3,4}, {2,-1}};
        System.out.println(findMinDistance(matrix2, 2));

        int[][] matrix3 = {{3,3}, {5,-1}, {-2,4}};
        System.out.println(findMinDistance(matrix3, 2));
    }

    private static List<List<Integer>> findMinDistance(int[][] matrix, int k) {
        Queue<int[]> maxHeap = new PriorityQueue<>((a,b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));

        for(int i=0; i < matrix.length; i++) {
            int[] curr = new int[2];
            for(int j=0; j < matrix[0].length; j++) {
                curr[j] = matrix[i][j];
            }
            maxHeap.offer(curr);

            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            List<Integer> currList = new ArrayList<>();
            currList.add(curr[0]);
            currList.add(curr[1]);
            result.add(currList);
        }

        return result;
    }
}
