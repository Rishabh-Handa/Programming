package dp;

/*
    https://leetcode.com/problems/maximum-number-of-points-with-cost/
 */
public class MaximumPointsWithCost {

    public static void main(String[] args) {
        int[][] points = {
                {1,2,3},
                {1,5,1},
                {3,1,1}
        };

        System.out.println(maxPoints(points));
    }

    public static long maxPoints(int[][] points) {
        if(points == null) {
            return 0;
        }

        long max = Long.MIN_VALUE;
        if(points.length == 1) {
            for(int i=0; i<points[0].length; i++) {
                if(max < points[0][i]) {
                    max = points[0][i];
                }
            }
            return max;
        }
        int n = points.length;
        int m = points[0].length;

        long dp[][] = new long[n][m];

        for(int j=0; j<m; j++) {
            dp[0][j] = points[0][j];
        }

        // O(n^3)
        // for(int i=1; i<n; i++) {
        //     for(int j=0; j<m; j++) {
        //         for(int k=0; k<m; k++) {
        //             dp[i][j] = Math.max(dp[i][j],
        //                                 points[i][j] + dp[i-1][k] - Math.abs(k -j) );
        //         }
        //     }
        // }

        // o(n^2)
        for(int i=1; i<n; i++) {
            long[] left = new long[m];
            long[] right = new long[m];

            left[0] = dp[i-1][0];
            right[m-1] = dp[i-1][m-1];

            for(int j=1; j<m; j++) {
                left[j] = Math.max(dp[i-1][j], left[j-1] - 1);
            }

            for(int j=m-2; j>=0; j--) {
                right[j] = Math.max(dp[i-1][j], right[j+1] - 1);
            }

            for(int j=0; j<m; j++) {
                dp[i][j] = points[i][j] + Math.max(left[j], right[j]);
                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }

    public static long maxPoints2(int[][] points) {
        if(points == null) {
            return 0;
        }

        long max = Long.MIN_VALUE;
        if(points.length == 1) {
            for(int i=0; i<points[0].length; i++) {
                if(max < points[0][i]) {
                    max = points[0][i];
                }
            }
            return max;
        }
        int n = points.length;
        int m = points[0].length;

        long[][] dp = new long[n][m];

        for(int j=0; j<m; j++) {
            dp[0][j] = points[0][j];
        }



        // o(n^2)
        for(int i=1; i<n; i++) {
            long[] left = new long[m];
            long[] right = new long[m];

            left[0] = dp[i-1][0];
            right[m-1] = dp[i-1][m-1];

            // if k<j (left to right),
            // A[k] + A[j] + j - k
            // max of A[k] - k + A[j] + j
        }

        return max;
    }
}
