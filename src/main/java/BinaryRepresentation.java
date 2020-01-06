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

	binaryRepresentation(12, bits, 0);

	for(int b=bits.length-1; b>=0; b--){
	    System.out.print(bits[b]);
	}
    }
}
