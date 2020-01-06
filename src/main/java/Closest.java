import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Closest {

    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	int testCases = Integer.parseInt(br.readLine());

	for(int i=0; i<testCases; i++){

	    String line  = br.readLine();
	    String[] strs = line.trim().split("\\s+");



	    int n = Integer.parseInt(strs[0]);
	    int d = Integer.parseInt(strs[1]);

	    int[] elements = new int[n];

	    line = br.readLine();
	    strs = line.trim().split("\\s+");

	    for (int j = 0; j < n; j++)
		elements[j] = Integer.parseInt(strs[j]);
	    StringBuffer output = new StringBuffer();

	    int[] diff = new int[n];

	    for(int k=0; k<n; k++){
	        diff[k] = Math.abs(d - elements[k]);
	    }

	    int min = diff[0];

	    for(int k=1; k<n; k++){
	        if(diff[k] < min){
	            min = diff[k];
		}
	    }

	    int max = 0;
	    for(int k=0; k<n; k++){
	        if(min == diff[k]){
		    if(max < elements[k])
		        max = elements[k];
		}
	    }




	    System.out.println(max);
	}

	br.close();

    }
}
