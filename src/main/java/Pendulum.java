import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pendulum {

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

	    sort(elements);

	    int[] pendulum = new int[n];

	    int minPos;
	    if(n%2 == 0)
	        minPos = (n-1)/2;
	    else
	        minPos = n/2;


	    int pos;
	    for(int k = 0; k< n; k++){
	        if(k%2==0){
	          pos = minPos - k/2;
	          pendulum[pos] = elements[k];
		}else{
	            pos = minPos + (k+1)/2;
	            pendulum[pos] = elements[k];
		}
	    }


	    for(int k=0; k<n;k++)
	        output.append(pendulum[k] + " ");

	    System.out.println(output);



	}

	br.close();

    }


    public static void sort(int[] elements){
        int n = elements.length;

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
}
