package learnjava.string;

public class StringTest {
    public static void main(String[] args) {
        String java = "java";
        String b2 = new String("java");

        System.out.println(java == b2);
        System.out.println(b2.equals(java));
    }

}
