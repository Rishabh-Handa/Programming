import java.util.HashMap;
import java.util.Map;

public class SumEqualTwoIntegers {

    public static void testSum(int[] elements, int sum){
        for(int i=0; i<elements.length; i++){
            for(int j=i+1; j<elements.length; j++){

                if((elements[i]+elements[j]) == sum)
		    System.out.print(elements[i] + " " + elements[j]);
	    }
	    System.out.println();
	}
    }

    public static void testSumMap(int[] elements, int sum){
	Map<Integer, Integer> map = new HashMap<>();
	for(int i=0; i<elements.length; i++){
	    map.put(elements[i], 0);
	}

	for(int i=0; i<elements.length; i++){
	    int sumLeft = sum - elements[i];
	    Integer value = map.get(sumLeft);
	    if(value !=null && value == 0){
		System.out.print(elements[i] + " " + sumLeft);
		map.put(sumLeft, -1);
		map.put(elements[i], -1);
	    }
	    System.out.println();
	}
    }




    public static void main(String[] args) {
        int[] elements = {1,2,3,4,5};
        testSumMap(elements, 5);

    }
}
