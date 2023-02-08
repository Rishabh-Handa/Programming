package graph;

import java.util.Arrays;

public class MultiStageGraphDP {

    public static void main(String[] args) {
        int[][] graph = {
                {0,2,1,3,0,0,0,0},
                {0,0,0,0,2,3,0,0},
                {0,0,0,0,6,7,0,0},
                {0,0,0,0,6,8,9,0},
                {0,0,0,0,0,0,0,6},
                {0,0,0,0,0,0,0,4},
                {0,0,0,0,0,0,0,5},
                {0,0,0,0,0,0,0,0}
        };

        getPath(graph);
    }


    private static void getPath(int[][] graph) {
        int n = graph.length;
        System.out.println("n=" + n);
        int[] parent = new int[n];
        int[] cost = new int[n];
        parent[0] = -1;

        for(int i=1; i<n; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for(int k=0; k<i; k++) {
                if(graph[k][i] != 0 && graph[k][i] + cost[k] < min) {
                    min = graph[k][i] + cost[k];
                    minIndex = k;
                }
            }
            cost[i] = min;
            parent[i] = minIndex;
        }
        Arrays.stream(cost).forEach(a -> System.out.print(a + ","));
        System.out.println();
        Arrays.stream(parent).forEach(a -> System.out.print(a + ","));

        System.out.println("\nMin cost = " + cost[n-1]);
        for(int i=n-1; i!=-1; i=parent[i]) {
            System.out.print(i+1 + "<-");
        }
    }
}
