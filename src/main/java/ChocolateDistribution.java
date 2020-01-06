import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Given an array A of positive integers of size N, where each value represents number of chocolates in a packet. Each packet can have variable number of chocolates. There are M students, the task is to distribute chocolate packets such that :
 * 1. Each student gets one packet.
 * 2. The difference between the number of chocolates given to the students having packet with maximum chocolates and student having packet with minimum chocolates is minimum.
 *
 * Input:
 * The first line of input contains an integer T, denoting the number of test cases. Then T test cases follow. Each test case consists of three lines. The first line of each test case contains an integer N denoting the number of packets. Then next line contains N space separated values of the array A denoting the values of each packet. The third line of each test case contains an integer m denoting the no of students.
 *
 * Output:
 * For each test case in a new line print the minimum difference.
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <=N<= 107
 * 1 <= Ai <= 1018
 * 1 <= M <= N
 *
 * Example:
 * Input:
 * 2
 * 8
 * 3 4 1 9 56 7 9 12
 * 5
 * 7
 * 7 3 2 4 9 12 56
 * 3
 *
 * Output:
 * 6
 * 2
 *
 * Explanation:
 * Testcase 1: The minimum difference between maximum chocolates and minimum chocolates is 9-3=6
 *
 * ** For More Input/Output Examples Use 'Expected Output' option **
 */

public class ChocolateDistribution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCases; i++) {
            int n = Integer.parseInt(br.readLine());

            int[] elements = new int[n];

            String line = br.readLine();
            String[] strs = line.trim().split("\\s+");

            int students =  Integer.parseInt(br.readLine());

            for (int j = 0; j < n; j++)
                elements[j] = Integer.parseInt(strs[j]);

            int diff = findLeastDifference(elements, students);

            System.out.println(diff);
        }

        br.close();

    }

    private static int findLeastDifference(int[] elements, int n) {
        List<Integer> packets = new ArrayList<>();
        for(int ele: elements){
            packets.add(ele);
        }

        Collections.sort(packets);

        int min = Integer.MAX_VALUE;

        for(int i=0; i+n-1<packets.size(); i++){
            int diff = packets.get(i+n-1) - packets.get(i);
            if(diff < min){
                min = diff;
            }
        }

        return min;
    }
}
