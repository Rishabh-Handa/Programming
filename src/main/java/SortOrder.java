import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class SortOrder {
    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	int testCases = Integer.parseInt(br.readLine());

	for (int i = 0; i < testCases; i++) {
	    int n = Integer.parseInt(br.readLine().trim());

	    int[] elements = new int[n];

	    String line = br.readLine();
	    String[] strs = line.trim().split("\\s+");

	    for (int j = 0; j < n; j++)
		elements[j] = Integer.parseInt(strs[j]);

	    StringBuffer output = new StringBuffer();

	   int[] odds = new int[n];
	   int[] evens = new int[n];

	   int evenCount = 0;
	   int oddCount = 0;

	   for(int k=0; k<n; k++){
	       if(elements[k] % 2 == 0){
	           evens[evenCount] = elements[k];
	           evenCount++;
	       }else{
	           odds[oddCount] = elements[k];
	           oddCount++;
	       }
	   }

	   sortDesc(odds, oddCount);

	   sortAsc(evens, evenCount);

	   for(int k=0; k< oddCount; k++)
	       output.append(odds[k] + " ");

	   for(int k=0; k<evenCount; k++){
	       output.append(evens[k] + " ");


	   }
	    System.out.println(output);
	}

	br.close();

    }

    public static void sortAsc(int[] elements, int n){

	for(int i=0; i<n-1; i++){
	    for(int j=0; j<n-i-1; j++) {
		if (elements[j] > elements[j + 1]) {
		    int c = elements[j];
		    elements[j] = elements[j + 1];
		    elements[j + 1] = c;
		}
	    }
	}
    }

    public static void sortDesc(int[] elements, int n){


	for(int i=0; i<n-1; i++){
	    for(int j=0; j<n-i-1; j++) {
		if (elements[j] < elements[j + 1]) {
		    int c = elements[j];
		    elements[j] = elements[j + 1];
		    elements[j + 1] = c;
		}
	    }
	}
    }
}
