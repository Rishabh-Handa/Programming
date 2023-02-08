package learnjava.testindexOf;

public class IndexOfTest {
    public static void main(String[] args) {
        String url = "http://localhost:8080/iss";

        System.out.println(url.indexOf("/iss", url.length() - 4));
    }
}
