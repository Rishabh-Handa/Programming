package greedy;

import java.util.ArrayList;
import java.util.List;

/*
        Given an array of size n that has the following specifications:
            1. Each element in the array contains either a policeman or a thief.
            2. Each policeman can catch only one thief.
            3. A policeman cannot catch a thief who is more than K units away from the policeman.

        Eg:
        {P, T , T , P, T} k=1; output = 2
        {T, T, P, P, T, P} k=2; output = 3
 */
public class CatchThieves {

    public static void main(String[] args) {
        int arr[] = {1, 0, 0, 1, 0};
        int k = 1;

        long start = System.currentTimeMillis();
        System.out.println(bruteForce(arr, k));
        System.out.println(bruteForce(new int[]{0,0,1,1,0,1,0,0,0,0,0,1,1,1,0,1,0,1,0,1,0,1}, 2));
        System.out.println(bruteForce(new int[]{1,1,0,1,1}, 2));
        System.out.println(bruteForce(new int[]{1,1,1,0,0}, 2));
        System.out.print(optimized(new int[]{0,0,1,1,0,1,0,0,0,0,0,1,1,1,0,1,0,1,0,1,0,1}, 2));
        System.out.print(optimized(new int[]{1,1,0,1,1}, 2));
        System.out.print(optimized(new int[]{1,1,1,0,0}, 2));
        System.out.print(optimized(new int[]{0,0,1,1,0,1,0,0,0,0,0,1,1,1,0,1,0,1,0,1,0,1}, 2));
        System.out.print(optimized(new int[]{1,1,0,1,1}, 2));
        System.out.print(optimized(new int[]{1,1,1,0,0}, 2));
        System.out.print(optimized(new int[]{0,0,1,1,0,1,0,0,0,0,0,1,1,1,0,1,0,1,0,1,0,1}, 2));
        System.out.print(optimized(new int[]{1,1,0,1,1}, 2));
        System.out.print(optimized(new int[]{1,1,1,0,0}, 2));
        long end = System.currentTimeMillis();

        System.out.println("Time taken = " + (end - start));


        System.out.println("Optimized");
        start = System.currentTimeMillis();
        System.out.println(optimized(arr, k));
        System.out.println(optimized(new int[]{0,0,1,1,0,1,0,0,0,0,0,1,1,1,0,1,0,1,0,1,0,1}, 2));
        System.out.println(optimized(new int[]{1,1,0,1,1}, 2));
        System.out.println(optimized(new int[]{1,1,1,0,0}, 2));
        System.out.print(optimized(new int[]{0,0,1,1,0,1,0,0,0,0,0,1,1,1,0,1,0,1,0,1,0,1}, 2));
        System.out.print(optimized(new int[]{1,1,0,1,1}, 2));
        System.out.print(optimized(new int[]{1,1,1,0,0}, 2));
        System.out.print(optimized(new int[]{0,0,1,1,0,1,0,0,0,0,0,1,1,1,0,1,0,1,0,1,0,1}, 2));
        System.out.print(optimized(new int[]{1,1,0,1,1}, 2));
        System.out.print(optimized(new int[]{1,1,1,0,0}, 2));
        System.out.print(optimized(new int[]{0,0,1,1,0,1,0,0,0,0,0,1,1,1,0,1,0,1,0,1,0,1}, 2));
        System.out.print(optimized(new int[]{1,1,0,1,1}, 2));
        System.out.print(optimized(new int[]{1,1,1,0,0}, 2));
        end = System.currentTimeMillis();

        System.out.println("Time taken = " + (end - start));

    }

    // Suppose 1=P and 0=T
    // O(n^2)
    static int bruteForce(int[] arr, int k) {
        int caught = 0;
        int[] visited = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 0) {
                continue;
            }
            for (int j = i-k; j <= i+k; j++) {
                if (j >= 0 && j < arr.length) {
                    if (arr[j] == 0 && visited[j] == 0) {
                        caught++;
                        visited[j] = 1;
                        break;
                    }
                }
            }
        }

        return caught;
    }

    // Suppose 1=P and 0=T
    // O(n)
    static int optimized(int[] arr, int k) {
        List<Integer> police = new ArrayList<>();
        List<Integer> thief = new ArrayList<>();

        for(int i=0; i<arr.length; i++) {
            if(arr[i] == 1) {
                police.add(i);
            } else {
                thief.add(i);
            }
        }

        int pi = 0, ti = 0;
        int caught = 0;

        while(pi < police.size() && ti < thief.size()) {
            if(Math.abs(police.get(pi) - thief.get(ti)) <= k) {
                caught++;
                pi++;
                ti++;
            }
            else if(police.get(pi) > thief.get(ti)) {
                ti++;
            } else {
                pi++;
            }
        }

        return caught;

    }
}
