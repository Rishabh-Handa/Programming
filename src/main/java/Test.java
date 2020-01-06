


import java.util.*;
		import java.lang.*;
		import java.io.*;

class GFG {
    public static void main (String[] args) throws IOException {
	//code
	//Scanner sc = new Scanner(System.in);
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int testCases = Integer.parseInt(br.readLine());

	int noOfElementsArr;
	String elementsStr;

	for(int i=0; i<testCases; i++){
	    noOfElementsArr = Integer.parseInt(br.readLine());
	    elementsStr = br.readLine();

	    String[] elements = elementsStr.split(" ");
	    int[] elementsInt = new int[elements.length];
	    int[] elementsOut = new int[elements.length];
	    for(int k = 0; k<elements.length;k++) {
		elementsInt[k] = Integer.parseInt(elements[k]);
		elementsOut[k] = -1;
	    }
	    int j;

	    StringBuffer output = new StringBuffer();
	    for(j = 1; j < elementsInt.length; j++) {
		if(elementsInt[j-1] > elementsInt[j]) {
		    elementsOut[j-1] = elementsInt[j];
		}
		output.append(elementsOut[j-1] + " ");

	    }
	    output.append(elementsOut[j-1] + " ");
	    System.out.println(output);

	}

    }

}

