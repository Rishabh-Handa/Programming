package graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DivisibleEquation {

    public static void main(String[] args) {
        List<List<String>> equations = Arrays.asList(Arrays.asList("a", "c"), Arrays.asList("b", "e"),
                Arrays.asList("c", "d"), Arrays.asList("e", "d"));
        double[] values = {2.0, 3.0,0.5,5.0};
        List<List<String>> queries = Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "e"));
        double[] answer = calcEquation(equations, values, queries);

        for(double ans: answer) {
            System.out.println(ans);
        }
    }
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Integer> nodesMap = new HashMap<>();
        int index = 0;
        for (List<String> nodes : equations) {
            for (String node : nodes) {
                if (!nodesMap.containsKey(node)) {
                    nodesMap.put(node, index);
                    index++;
                }
            }
        }

        int n = nodesMap.keySet().size();

        double[][] matrix = new double[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i==j) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = Double.MAX_VALUE;
                }
            }
        }

        for(int i=0; i<equations.size(); i++) {
            List<String> nodes = equations.get(i);
            String u = nodes.get(0);
            String v = nodes.get(1);

            int uIndex = nodesMap.get(u);
            int vIndex = nodesMap.get(v);

            matrix[uIndex][vIndex] = values[i];
            matrix[vIndex][uIndex] = 1.0/values[i];
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println();
        }
        System.out.println("----------------");
        for(int k=0; k<n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][k] == Double.MAX_VALUE || matrix[k][j] == Double.MAX_VALUE) {
                        matrix[i][j] = matrix[i][j];
                    } else {
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] * matrix[k][j]);
                    }
                }
            }
        }

        System.out.println(nodesMap);
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println();
        }

        double[] answer = new double[queries.size()];
        for(int i=0; i<queries.size(); i++) {
            List<String> nodes = queries.get(i);
            String u = nodes.get(0);
            String v = nodes.get(1);

            if(!nodesMap.containsKey(u) || !nodesMap.containsKey(v)) {
                answer[i] = -1.0;
                continue;
            }
            int uIndex = nodesMap.get(u);
            int vIndex = nodesMap.get(v);

            if(Double.MAX_VALUE == matrix[uIndex][vIndex]) {
                answer[i] = -1.0;
            } else {
                answer[i] = matrix[uIndex][vIndex];
            }
        }

        return answer;
    }

}
