package learnjava.collectionstest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SumAllList {
    public static void main(String[] args) {
        List<Integer> arrayList = Arrays.asList(1,2,3,4,5,6);
        int s1 = 0;
        for(int r: arrayList) {
            s1 += r;
        }
        System.out.println(arrayList);
        int sum = arrayList.stream().reduce(0, Integer::sum);
        System.out.println(s1);
        System.out.println(sum);
        System.out.println(arrayList);

        int s3 = 0;
        System.out.println(arrayList.stream().mapToInt(x -> x).sum());


    }
}
