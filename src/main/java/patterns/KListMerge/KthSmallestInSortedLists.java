package patterns.KListMerge;

import java.util.*;

/**
 * Input: L1=[5, 8, 9], L2=[1, 7], K=3
 * Output: 7
 * Explanation: The 3rd smallest number among all the arrays is 7.
 */
public class KthSmallestInSortedLists {
    public static void main(String[] args) {
        int[][] matrix = {{2,6,8},
                {3,6,7}, {1,3,4}};

        System.out.println(printSorted(matrix,5));

        int[][] matrix2 = {{5,8,9}, {1,7}};

        System.out.println(printSorted(matrix2, 3));
    }

    private static class Element {
        int val;
        int i;
        int j;

        Element(int val, int i, int j) {
            this.val = val;
            this.i = i;
            this.j = j;
        }
    }
    private static int printSorted(int[][] lists, int k) {
        int n = lists.length;

        Queue<Element> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for(int i=0; i<n; i++) {
            minHeap.offer(new Element(lists[i][0], i, 0));
        }

        int count = 0;

        while(!minHeap.isEmpty()) {
            Element currElement = minHeap.poll();
            count++;
            if(count == k) {
               return currElement.val;
            }

            if(currElement.j + 1 < lists[currElement.i].length) {
                minHeap.offer(new Element(lists[currElement.i][currElement.j + 1], currElement.i, currElement.j + 1));
            }
        }

        return -1;
    }
}
