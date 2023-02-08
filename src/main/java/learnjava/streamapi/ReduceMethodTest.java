package learnjava.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceMethodTest {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);

        Optional<Integer> singleResult = list.stream().reduce( (a, b) -> a + b);
        int secondResult = list.stream().reduce(8, (a, b) -> {
            //System.out.println(a + "," + b);
            return a - b;});


        System.out.println(singleResult);
        System.out.println(secondResult);

        List<String> listString = Arrays.asList("123", "123456", "1234","1234567", "12");
        System.out.println(listString.stream().reduce((a,b) -> a.length() > b.length() ? a : b));
    }
}
