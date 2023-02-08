package dp;

/*
        A child is running up a staircase with n steps and can hop
        either 1 step, 2 steps, or 3 steps at a time.
        Implement a method to count how many possible ways the child can run up the stairs.

        Examples:

        Input : 4
        Output : 7

 */
public class CountStairs {
    public static void main(String[] args) {
        System.out.println(count(0, 4));
        System.out.println(count(0, 3));

        System.out.println("------DP------");
        System.out.println(countDP(4));
        System.out.println(countDP(3));
    }

    static int count(int currStep, int k) {
        if(currStep > k) {
            return 0;
        }

        if(currStep == k) {
            return 1;
        }

        int step1 = count(currStep + 1, k);
        int step2 = count(currStep + 2, k);
        int step3 = count(currStep + 3, k);

        return step1 + step2 + step3;
    }

    static int countDP(int k) {
        int[] dp = new int[k+1];
        dp[0] = 1;

        for(int i=1; i<=k; i++) {
            int curr = 0;
            if(i-1 >= 0) {
                curr += dp[i-1];
            }
            if(i-2 >= 0) {
                curr += dp[i-2];
            }
            if(i-3 >= 0) {
                curr += dp[i-3];
            }
            dp[i] = curr;
        }

        return dp[k];
    }
}
