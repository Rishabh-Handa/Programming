package math;

public class LCMHCF {

    public static void main(String[] args) {
        System.out.println(hcf(24, 18));
        System.out.println(gcd(18, 24));
        System.out.println("LCM = " + (75*30) / hcf(30, 75));
    }

    static int hcf(int a, int b) {
        if(a == b) {
            return a;
        }

        if(a > b) {
            int remainder = a % b;
            if(remainder == 0) {
                return b;
            }
            return hcf(remainder, b);
        } else {
            int remainder = b % a;
            if(remainder == 0) {
                return a;
            }
            return hcf(remainder, a);
        }

    }

    static int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
