package graph;

import java.util.Arrays;

public class DjikstraAlgorithm {
    public static void main(String[] args) {
        int[][] graph = {
                {100,2,4,100,100,100},
                {100,100,1,7,100,100},
                {100,100,100,100,3,100},
                {100,100,100,100,100,1},
                {100,100,100,2,100,5},
                {100,100,100,100,100,100}
        };

        int[] result = djikstraAlgo(graph);

        System.out.println("Result");
        Arrays.stream(result).forEach(a -> System.out.print(a + ","));

        int[][] graph2 = {
                {100,50,45,10,100,100},
                {100,100,10,15,100,100},
                {100,100,100,100,30,100},
                {10,100,100,100,15,100},
                {100,20,35,100,100,100},
                {100,100,100,100,3,100}
        };

        int[] result2 = djikstraAlgo(graph2);

        System.out.println("Result");
        Arrays.stream(result2).forEach(a -> System.out.print(a + ","));
    }

    static int[] djikstraAlgo(int[][] graph) {
        int n = graph.length;

        int[] visited = new int[n];
        int i = findMinIndex(graph, visited);
        while (i != -1) {
            for(int j=0; j<n; j++) {
                if(visited[j] != 1 && graph[i][j] != 100 && graph[0][j] > graph[0][i] + graph[i][j]) {
                    graph[0][j] = graph[0][i] + graph[i][j];
                }
            }
            i = findMinIndex(graph, visited);
        }

        return graph[0];
    }

    static int findMinIndex(int[][] graph, int[] visited) {
        int n = graph.length;
        int min = 100;
        int minIndex = -1;
        Arrays.stream(graph[0]).forEach(a -> System.out.print(a + ","));
        for(int j=0; j<n; j++) {
            if(graph[0][j] < min && visited[j] != 1) {
                min = graph[0][j];
                minIndex = j;
            }
        }
        if(minIndex != -1) {
            visited[minIndex] = 1;
        }
        System.out.println("j=" + minIndex);
        return minIndex;
    }
}
