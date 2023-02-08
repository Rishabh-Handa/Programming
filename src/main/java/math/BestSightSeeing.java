package math;

/*
    https://leetcode.com/problems/best-sightseeing-pair/
    You are given an integer array values where values[i] represents the value of the ith sightseeing spot. Two sightseeing spots i and j have a distance j - i between them.

    The score of a pair (i < j) of sightseeing spots is values[i] + values[j] + i - j: the sum of the values of the sightseeing spots, minus the distance between them.

    Return the maximum score of a pair of sightseeing spots.

    Input: values = [8,1,5,2,6]
    Output: 11
    Explanation: i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
 */
public class BestSightSeeing {
    public static void main(String[] args) {
        // The solution can be reduced to maximize A[i] + i + A[j] - j
        // so we can consider i=0 as max initially and then as we find some index with A[i] + i > max,
        // we can update it
        // And keep on adding A[j] - j to check the result, j = i+1, i+2 and so on

        int[] values = {8,1,5,2,6};
        int[] val2 = {8,1,3,7,7,4,2};
        System.out.println(maxScoreSightseeingPair(values));
        System.out.println("Max of 2 numbers = " + maxOf2Numbers(values));
        System.out.println("Max of 2 numbers 2 = " + maxOf2Numbers2(values));


        System.out.println("2nd try = " + maxScoreSightseeingPair2(values));
        System.out.println("2nd try = " + maxScoreSightseeingPair2(val2));


        System.out.println(maxScoreSightseeingPair(val2));
        System.out.println("Max of 2 numbers = " + maxOf2Numbers(val2));
        System.out.println("Max of 2 numbers 2 = " + maxOf2Numbers2(val2));

    }

    public static int maxScoreSightseeingPair(int[] values) {
        int max = values[0] + 0;
        int result = 0;

        for(int i=1; i<values.length; i++) {
            result = Math.max(result, max + values[i] - i);
            max = Math.max(max, values[i] + i);
        }

        return result;
    }

    public static int maxScoreSightseeingPair2(int[] values) {
        int result = values[0];
        int prevMax = values[0];

        for(int i=1; i<values.length; i++) {
            result = Math.max(result, values[i] + prevMax - 1);
            prevMax = Math.max(prevMax - 1, values[i]);
        }

        return result;
    }

    public static int maxOf2Numbers(int[] values) {
        int max = values[0];
        int result = 0;

        for(int i=1; i<values.length; i++) {
            result = Math.max(result, max + values[i]);
            max = Math.max(max, values[i]);
        }

        return result;
    }
    public static int maxOf2Numbers2(int[] values) {
        int max = 0;
        int secondMax = 0;

        for(int i=0; i<values.length; i++) {
            if(max < values[i]) {
                secondMax = max;
                max = values[i];
            } else if(secondMax < values[i]) {
                secondMax = values[i];
            }
        }

        return max + secondMax;

    }
}
