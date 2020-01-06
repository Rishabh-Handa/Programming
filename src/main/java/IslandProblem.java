

import java.util.*;

class Solution {


    public static int search(int[][] matrix, int i, int j){
	if(i<0 || j<0 || i >= matrix.length || j>=matrix[0].length || matrix[i][j] == 0)
	    return 0;

	matrix[i][j] = 0;

	search(matrix, i+1, j);
	search(matrix, i-1, j);
	search(matrix, i, j+1);
	search(matrix, i, j-1);

	return 1;
    }

    public static void main(String[] args) {

	int[][] matrix = {
			{0,0,0},
			{1,1,0},
			{1,1,0},
			{0,0,1},
			{0,0,1},
			{1,1,0}
	};

	int count = 0;
	for(int i=0; i<matrix.length; i++){
	    for(int j=0; j<matrix[0].length; j++){
		if(matrix[i][j] == 1){
		    count = count + search(matrix, i, j);
		}
	    }
	}

	System.out.println(count);




    }
}
