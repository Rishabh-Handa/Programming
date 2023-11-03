package puzzle;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class PrintSpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix =    {
                                {1,2,3,4},
                                {5,6,7,8},
                                {9,10,11,12}
                            };
        System.out.println(spiralOrder(matrix));

    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix == null) {
            return result;
        }

        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;

        while(left <= right && top <= bottom) {

            // left -> right
            for(int i=left; i<=right; i++) {
                result.add(matrix[top][i]);
            }
            top++;


            // top -> bottom
            for(int i=top; i<=bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // right -> left
            for(int i=right; i>=left && top<=bottom; i--) {
                result.add(matrix[bottom][i]);
            }
            bottom--;

            // bottom -> top
            for(int i=bottom; i>=top && left<=right; i--) {
                result.add(matrix[i][left]);
            }
            left++;
        }
        return result;
    }
}
