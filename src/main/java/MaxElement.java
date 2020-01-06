import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MaxElement {

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

	    StringBuffer output = new StringBuffer();

	    int max = elements[n-1];

	    int[] leaders = new int[n];
	    int count = 0;

	    leaders[count] = max;
	    count++;
	    for (int x = n-2; x >= 0; x--) {
	        if(elements[x] >= max){
	            max = elements[x];
	            leaders[count] = max;
	            count++;
		}

	    }



	    for(int x = count-1; x>=0; x--){
	        output.append(leaders[x] + " ");
	    }

	    System.out.println(output);
	}

	br.close();

    }
}
