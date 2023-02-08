public class BinaryRepresentation {

    public static void binaryRepresentation(int n, int[] bits, int count ){
        if(n < 2){
            bits[count] = 1;
            return;
	}

	int bit = n%2;
        bits[count] = bit;

        binaryRepresentation(n/2, bits, ++count);
    }



    public static void main(String[] args) {
	int[] bits = new int[8];

	binaryRepresentation(37, bits, 0);

	for(int b=bits.length-1; b>=0; b--){
	    System.out.print(bits[b]);
	}

        System.out.println("\nNew");
        System.out.println(binaryRepresentation(37));
    }

    // 18/06/2022
    static String binaryRepresentation(int n) {
        return recurBinary(n, "");
    }

    static String recurBinary(int n, String result) {
        if(n <= 0) {
            return result;
        }

        int binary = n % 2;
        result = binary + result;
        return recurBinary(n/2, result);
    }
}
