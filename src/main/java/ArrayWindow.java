import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Collectors;

/*

Given an array A and an integer K. Find the maximum for each and every contiguous subarray of size K.
 */


public class ArrayWindow {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCases; i++) {

            String line1 = br.readLine();
            String[] strs1 = line1.trim().split("\\s+");
            int n = Integer.parseInt(strs1[0]);
            int k = Integer.parseInt(strs1[1]);

            int[] elements = new int[n];

            String line = br.readLine();
            String[] strs = line.trim().split("\\s+");

            for (int j = 0; j < n; j++)
                elements[j] = Integer.parseInt(strs[j]);


            StringBuilder output = new StringBuilder();

            possibleLetters(n, elements, output, k);

            System.out.println(output);


        }

        br.close();

    }

    private static void possibleLetters(int n, int[] elements, StringBuilder output, int k) {
        int max;
        for(int i=0; i<n-k+1; i++){
            max = Integer.MIN_VALUE;
            for(int j=i; j<i+k; j++){
                max = elements[j] > max ? elements[j] : max;
            }

            output.append(max + " ");
        }
    }



}



/* sliding window concept

import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    static int arr[] = new int[10000000];

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();



        while(t-- > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();

            for(int i = 0; i <n; i++)
            {
                arr[i] =sc.nextInt();


            }

            max_of_subarrays(n, k);
        }
    }


    static void max_of_subarrays(int n, int k)
    {
        Deque<Integer> dq = new LinkedList<>();      // Defining the deque data structure.
        StringBuilder sb = new StringBuilder();

        int i = 0;
        for(i  = 0; i < k ; i++)                    // Running for the first k numbers
        {
            while(dq.isEmpty() == false && arr[i] >= arr[dq.peekLast()])    // Store the biggest number at queue front always
              dq.pollLast();

              dq.add(i);
        }

        for(; i < n; i++)                   // Sliding window technique
        {

            sb.append(arr[dq.peek()] + " ");

            while(dq.isEmpty() == false && (dq.peekFirst() <= i-k))
               dq.pollFirst();                      // Removing the front if it is no more in the range.

             while(dq.isEmpty() == false && (arr[i] >= arr[dq.peekLast()]))
                dq.pollLast();                      // Pop all the smaller numbers from back.

            dq.add(i);          // Push the current number index
        }

          sb.append(arr[dq.peek()]);
           dq.pollFirst();
          System.out.println(sb);

    }
}


 */
