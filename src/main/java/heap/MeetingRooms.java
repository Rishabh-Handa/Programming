package heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRooms {

    public static void main(String[] args) {
        int[][] a = {{0,30}, {15,20}, {5,10} };
        int[][] b = {{1, 18}, {18, 23}, {15, 29}, {4, 15}, {2, 11}, {5, 13}};

        //System.out.println(solve(a));

        System.out.println(solve(b));
    }
    public static int solve(int[][] A) {
        Queue<Integer> queue = new PriorityQueue<>();

        Arrays.sort(A, (a, b) -> a[0] - b[0]);

        // Arrays.stream(A).forEach( a -> System.out.print(a[0] + ","));
        //System.out.println();
        queue.add(A[0][1]);

        for(int i=1; i<A.length; i++) {
            int[] currInterval = A[i];
            if (currInterval[0] >= queue.peek()) {
                queue.poll();
            }
            queue.add(currInterval[1]);
        }

        return queue.size();
    }
}
