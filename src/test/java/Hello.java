import java.util.*;
import java.util.stream.Collectors;

public class Hello {


    public static int minSum(List<Integer> num, int k) {
	// Write your code h

	Collections.sort(num, Collections.reverseOrder());


	int count = 0;

	for(int i=0; i<k; i++){
	    if(count==(num.size() - 1)){
	        count = 0;
	    }

	    float j = num.get(count);

	    float u = j/2;

	    int roundedValue = (int)Math.ceil(u);



	    num.set(count, roundedValue);
	    count++;
	}

	return num.stream().mapToInt(Integer::intValue).sum();

    }

	static List<Integer> reverseOrder(boolean flag) {
		int[] arr = {1,2,3,4,5};

		List<Integer> list = new ArrayList<>();
		for(int x: arr) {
			list.add(x);
		}

		//Collections.reverse(list);
		for(int i=0, j=list.size() - 1; i<j; i++, j--) {
			int temp = list.get(i);
			list.set(i, list.get(j));
			list.set(j, temp);
		}
		return list;
	}

    public static void main(String[] args) {
	int x = minSum(Arrays.asList(2, 3), 1);

	System.out.println(x);

		System.out.println(reverseOrder(true));
    }
}
