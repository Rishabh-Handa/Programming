import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*

Given an array of integers, write a function that returns true if there is a triplet (a, b, c) that satisfies a^2 + b^2 = c^2.
 */


public class PythaTriplet {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCases; i++) {
            int n = Integer.parseInt(br.readLine());

            int[] elements = new int[n];

            String line = br.readLine();
            String[] strs = line.trim().split("\\s+");

            for (int j = 0; j < n; j++)
                elements[j] = Integer.parseInt(strs[j]);

            boolean flag = pythaTriplet(elements, n);

            if(flag)
                System.out.println("Yes");
            else
                System.out.println("No");
        }

        br.close();

    }

    private static boolean pythaTriplet(int[] elements, int n) {

        ArrayList<Integer> squared = new ArrayList<>();

        for(int i=0; i<n; i++){
            squared.add(elements[i] * elements[i]);
        }

        for(int i=0; i<squared.size(); i++){
            for(int j=0; j<squared.size(); j++){
                int sum = squared.get(i) + squared.get(j);

                if(squared.stream().anyMatch(e -> e==sum)){
                    return true;
                }
            }
        }

        return false;
    }

}
