package tree;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] array = {12,11,13,5,6,7,6,3,14,18};
        heapsort(array);

        System.out.println("answer=");
        Arrays.stream(array).forEach(x -> System.out.print(x+","));
    }

    /*
        1. start from 1st non-leaf node till 0
        2. for each element compare it with its both children and replace the ith with the greatest of both the children
        3. repeat till you find the correct position of the node
        4.
     */
    static int[] heapsort(int[] arr) {
        int n = arr.length;

        for(int i=(n/2)-1; i>=0; i--) {
            heapify(arr, n, i);
        }

        System.out.println("heapify");
        Arrays.stream(arr).forEach(x -> System.out.print(x+","));

        for(int i=n-1; i>0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            heapify(arr, i, 0);
        }

        return arr;
    }

    static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2*i+1;
        int right = 2*i+2;

        if(left<n && arr[left] > arr[largest]) {
            largest = left;
        }

        if(right<n && arr[right] > arr[largest]) {
            largest = right;
        }

        if(largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }
}
