package dp;

import java.util.*;

/**
 *  Travel from 1 to each node and come back to 1
 *  Find the shortest route
 */
public class TravellingSalesman {

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 10, 15, 20},
                {5, 0, 9, 10},
                {6, 13, 0, 12},
                {8, 8, 9, 0}
        };
        int min = minimumPathBFS(matrix);
    }

    private static int minimumPathBFS(int[][] matrix) {
        int n = matrix.length;
        int source = 0;
        int[] prev = new int[n];
        int[] dp = new int[n];

        for(int i=0; i<n; i++) {
            if(i != source) {
                prev[i] = matrix[source][i];
            }
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            if(i != source) {
                List<Integer> adjList = new ArrayList<>();
                for(int j=0; j<n; j++) {
                    if( i != j && j != source) {
                        adjList.add(j);
                    }
                }
                map.put(i, adjList);
            }
        }

        Arrays.stream(prev).forEach(a -> System.out.print(a + ","));
        System.out.println();
        System.out.println("Map = " + map);




        return 0;
    }
}


