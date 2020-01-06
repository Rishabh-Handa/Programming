import java.math.BigDecimal;
import java.math.MathContext;

public class PlusMinus {




    static void plusMinus(int[] arr) {
        int positive = 0;
        int negative = 0;
        int zeros = 0;


        int total = arr.length;


        for(int i=0; i < arr.length; i++){
            if(arr[i] > 0){
                positive++;
	    }

	    if(arr[i] < 0){
                negative++;
	    }

	    if(arr[i] == 0)
	        zeros++;
	}

	BigDecimal positiveDecimal = new BigDecimal(positive).divide(new BigDecimal(total), 6, 5);
	BigDecimal negativeDecimal = new BigDecimal(negative).divide(new BigDecimal(total), 6, 5);
	BigDecimal zeroDecimal = new BigDecimal(zeros).divide(new BigDecimal(total), 6, 5);
	System.out.println(positiveDecimal);
	System.out.println(negativeDecimal);
	System.out.println(zeroDecimal);
    }


    public static void main(String[] args) {
	plusMinus(new int[]{-4, 3, -9, 0, 4, 1});
    }
}
