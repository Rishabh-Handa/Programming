package patterns.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class SumOfKElements {

    public static void main(String[] args) {
        int[] arr = {1,3,2,6,-1,4,1,8,2};
        int k = 5;
        List<Double> avg = slidingWindow(arr, k);

        System.out.println("Result = ");
        avg.forEach(x -> System.out.print(x + ","));
    }

    static List<Double> slidingWindow(int[] arr, int k) {
        double sum = 0;
        for(int i=0; i<k; i++) {
            sum += arr[i];
        }

        List<Double> avg = new ArrayList<>();
        avg.add(sum/k);

        int prev = 0;
        for(int i=k; i<arr.length; i++, prev++) {
            sum = sum + arr[i] - arr[prev];
            avg.add(sum/k);
        }

        return avg;
    }
}
