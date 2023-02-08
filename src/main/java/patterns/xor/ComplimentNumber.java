package patterns.xor;

/**
 * Every non-negative integer N has a binary representation, for example,
 * 8 can be represented as “1000” in binary and 7 as “0111” in binary.
 *
 * The complement of a binary representation is the number in binary that
 * we get when we change every 1 to a 0 and every 0 to a 1. For example, the binary complement of “1010” is “0101”.
 *
 * For a given positive number N in base-10, return the complement of its binary representation as a base-10 integer.
 *
 * Example 1:
 *
 * Input: 8
 * Output: 7
 * Explanation: 8 is 1000 in binary, its complement is 0111 in binary, which is 7 in base-10.
 */
public class ComplimentNumber {
    public static void main(String[] args) {
        System.out.println(findComplement(8));
        System.out.println(findComplement(10));
    }

    private static int findComplement(int num) {
        int bits = 0;
        int x = num;
        while(num > 0) {
            bits++;
            num = num/2;
        }
        int sum = 0;
        for(int i=0; i < bits; i++) {
            sum += (int) Math.pow(2, i);
        }

        return x ^ sum;
    }
}
