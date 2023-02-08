package patterns.KListMerge;

import java.util.*;

/**
 * Given an array of ‘K’ sorted LinkedLists, merge them into one sorted list.
 *
 * Example 1:
 *
 * Input: L1=[2, 6, 8], L2=[3, 6, 7], L3=[1, 3, 4]
 * Output: [1, 2, 3, 3, 4, 6, 6, 7, 8]
 */
public class MergeKLists {
    public static void main(String[] args) {
        int[][] matrix = {{2,6,8},
                {3,6,7}, {1,3,4}};

        System.out.println(printSorted(matrix));

        int[][] matrix2 = {{5,8,9}, {1,7}};

        System.out.println(printSorted(matrix2));
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
    private static List<Integer> printSorted(int[][] lists) {
        int n = lists.length;

        Queue<Element> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for(int i=0; i<n; i++) {
            minHeap.offer(new Element(lists[i][0], i, 0));
        }

        List<Integer> result = new ArrayList<>();

        while(!minHeap.isEmpty()) {
            Element currElement = minHeap.poll();
            result.add(currElement.val);

            if(currElement.j + 1 < lists[currElement.i].length) {
                minHeap.offer(new Element(lists[currElement.i][currElement.j + 1], currElement.i, currElement.j + 1));
            }
        }

        return result;
    }
}
