/*

    Problem -
    Given a N X N  matrix Matrix[N][N] of positive integers.
    There are only three possible moves from a cell Matrix[r][c].

        1. Matrix[r+1][c]

        2. Matrix[r+1][c-1]

        3. Matrix[r+1][c+1]

    Starting from any column in row 0, return the largest sum of any of the paths up to row N-1.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumCost {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(br.readLine());

        for(int i=0; i<testCases; i++){
            int n = Integer.parseInt(br.readLine());

            int[][] elements = new int[n][n];

            String line = br.readLine();
            String[] strs = line.trim().split("\\s+");

            int count = 0;
            for (int j = 0; j < n; j++)
                for(int k=0; k< n; k++) {
                    elements[j][k] = Integer.parseInt(strs[count]);
                    count++;
                }


            StringBuffer output = new StringBuffer();

            int max = findMaxPath(elements, n);

            System.out.println(max);
        }

        br.close();

    }


    public static int findMaxPath(int[][] elements, int n){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int a = i-1, b=j-1, c=j+1;
                int ele1=0,ele2=0,ele3=0;
                if(a>=0)
                    ele1 = elements[a][j];
                if(a>=0 && b>=0)
                    ele2 = elements[a][b];
                if(a>=0 && c<=n-1)
                    ele3 = elements[a][c];

                int max = 0;
                if(ele1 >= ele2 && ele1 >=ele3)
                    max = ele1;
                else if(ele2 >= ele3)
                    max = ele2;
                else
                    max = ele3;

                elements[i][j] = elements[i][j] + max;
            }
        }


        int max = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(elements[i][j] >= max)
                    max = elements[i][j];
            }
        }

        return max;

    }
}
