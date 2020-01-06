import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class NextElementSmaller {

    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	int testCases = Integer.parseInt(br.readLine());

	for(int i=0; i<testCases; i++){
	    int n = Integer.parseInt(br.readLine());

	    int[] elements = new int[n];

	    String line = br.readLine();
	    String[] strs = line.trim().split("\\s+");

	    for (int j = 0; j < n; j++)
		elements[j] = Integer.parseInt(strs[j]);


	    StringBuffer output = new StringBuffer();

	    for(int j=0; j<n; j++){
	        int k = j+1;
	        if(k==n) {
		    output.append("-1");
		    continue;
		}

	        if(elements[k] < elements[j])
		    output.append(elements[k] + " ");
	        else
		    output.append(-1 + " ");
	    }

	    System.out.println(output);
	}

	br.close();

    }
}
