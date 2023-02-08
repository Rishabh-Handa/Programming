package dp;

import java.util.Arrays;

/**
 *  Find maximum price of the sack of given weight
 *  that can be obtained using different products of different weights
 *  each object can be only added once
 *
 *  P = {1,2,5,6}
 *  W = {2,3,4,5}
 *
 *  k = 8
 *  max weight = 8, by including W = {3,5}
 *
 */
public class Knapsack01 {
    public static void main(String[] args) {
        int[] price = {5,2,1,6};//{1,2,5,6};
        int[] weight = {4,3,2,5};//{2,3,4,5};
        int k = 8;
        System.out.println("max weight = " + maxWeight(price, weight, 8));
        System.out.println("max weight = " + maxWeight(new int[]{60, 100, 120}, new int[]{10,20,30}, 50));
        System.out.println("max weight = " + maxWeight(new int[]{10, 15, 40}, new int[]{1,2,3}, 6));
    }

    static int maxWeight(int[] price, int[] weight, int k) {
        int[] prevDp = new int[k+1];
        int[] dp = new int[k+1];
        dp[0] = 0;

//        for(int i=1; i<=k; i++) {
//            for(int j=0; j<weight.length; j++) {
//                if(i-weight[j] >= 0 && dp[i] < price[j] + dp[i-weight[j]]) {
//                    dp[i] = price[j] + dp[i-weight[j]];
//                }
//            }
//        }

        for(int i=0; i<weight.length; i++) {
            for(int j=1; j<=k; j++) {
                int prev = j - weight[i];
                if(prev >= 0) {
                    dp[j] = Math.max(dp[j], price[i] + prevDp[prev]);
                }
            }
            for(int z=0; z<dp.length; z++) {
                prevDp[z] = dp[z];
            }
        }

//        for(int i=0; i<weight.length; i++) {
//            for(int j=k; j>=weight[i]; j--) {
//                int prev = j - weight[i];
//                dp[j] = Math.max(dp[j], price[i] + dp[prev]);
//            }
//            Arrays.stream(dp).forEach(v -> System.out.print(v + ","));
//            System.out.println();
//        }

        Arrays.stream(dp).forEach(v -> System.out.print(v + ","));
        System.out.println();
        return dp[k];
    }
}
