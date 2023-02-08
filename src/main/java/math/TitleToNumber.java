package math;

import java.util.Arrays;

/*
https://leetcode.com/problems/excel-sheet-column-number/
Given a string columnTitle that represents the column title
as appears in an Excel sheet, return its corresponding column number.

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
 */
public class TitleToNumber {

    public static void main(String[] args) {
        String[] testCases ={"A", "AA", "AB", "ZY", "AXR"};

        System.out.println("result");
        Arrays.stream(testCases).forEach(t -> System.out.print(titleToNumber(t) + ","));
    }
    public static int titleToNumber(String columnTitle) {
        int n = columnTitle.length();

        int score = 0;
        for(int i=n-1, j=0; i>=0; i--,j++) {
            int currentChar = columnTitle.charAt(i) - 65 + 1;
            score += Math.pow(26, j) * currentChar;
        }

        return score;
    }
}
