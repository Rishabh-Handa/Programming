package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPermutation {

    public static void main(String[] args) {
        //printAllPermutations("cab");
        printAllPermutations2("abc");
    }

    static void printAllPermutations2(String str) {
        char[] chars = str.toCharArray();
        printAllPermutations2Util(chars, 0);
    }

    static void printAllPermutations2Util(char[] chars, int index) {
        if(chars.length - 1 == index) {
            System.out.print(new String(chars) + ", ");
            return;
        }

        for(int i=index; i<chars.length; i++) {
            swap(chars, index, i);
            printAllPermutations2Util(chars, index + 1);
            swap(chars, index, i);
        }

    }

    static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
    static void printAllPermutations(String str) {
        char[] strCharArray = str.toCharArray();
        int[] count = new int[str.length()];

        Arrays.fill(count, 1);

        char[] result = new char[str.length()];

        printAllPermutations(result, 0, strCharArray, count);
    }

    private static void printAllPermutations(char[] result, int lengthCount, char[] str, int[] count) {
        if(lengthCount == str.length) {
            System.out.print(result); System.out.print(",");
            return;
        }

        for(int i=0; i<str.length; i++) {
            if(count[i] == 1) {
                result[lengthCount] = str[i];
                lengthCount++;
                count[i] = 0;
                printAllPermutations(result, lengthCount, str, count);
                count[i] = 1;
                lengthCount--;
            }
        }
    }
}
