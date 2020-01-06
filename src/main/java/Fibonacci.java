public class Fibonacci {

    public static void main(String[] args) {

        int sum = 8;

        int[] fibonacci = new int[sum];

        fibonacci[0] = 1;
        fibonacci[1] = 1;

        for(int i=2; i<fibonacci.length; i++){
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
	}

	for(int val: fibonacci){
	    System.out.print(val);
	    System.out.print(",");
	}
    }
}
