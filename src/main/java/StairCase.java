public class StairCase {


    static void staircase(int n) {

        for(int i=0; i<n; i++) {
	    for (int j = n - 1 - i; j > 0; j--) {
		System.out.print(" ");
	    }
	    for(int k=i+1; k>0; k--){
		System.out.print("#");
	    }

	    System.out.println();
	}
    }

    public static void main(String[] args) {
	staircase(9);
    }
}
