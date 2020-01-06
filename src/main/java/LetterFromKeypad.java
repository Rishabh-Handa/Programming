import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
import java.util.stream.Collectors;

/*

Given a keypad as shown in diagram, and an N digit number. List all words which are possible by pressing these numbers.
 */


public class LetterFromKeypad {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCases; i++) {
            int n = Integer.parseInt(br.readLine());

            int[] elements = new int[n];

            String line = br.readLine();
            String[] strs = line.trim().split("\\s+");

            for (int j = 0; j < n; j++)
                elements[j] = Integer.parseInt(strs[j]);


            StringBuilder output = new StringBuilder();

            possibleLetters(n, elements, output);

            System.out.println(output);


        }

        br.close();

    }

    private static void possibleLetters(int n, int[] elements, StringBuilder output) {
        Map<Integer, List<String>> keypad = new HashMap<>();

        keypad.put(2, Arrays.asList("a", "b", "c"));
        keypad.put(3, Arrays.asList("d", "e", "f"));
        keypad.put(4, Arrays.asList("g", "h", "i"));
        keypad.put(5, Arrays.asList("j", "k", "l"));
        keypad.put(6, Arrays.asList("m", "n", "o"));
        keypad.put(7, Arrays.asList("p", "q", "r", "s"));
        keypad.put(8, Arrays.asList("t", "u", "v"));
        keypad.put(9, Arrays.asList("w", "x", "y", "z"));

        List<List<String>> wordList = new ArrayList<>();

        for(int i=0; i<elements.length; i++){
            wordList.add(keypad.get(elements[i]));
        }



        List<String> result = null;
        for(int i=0; i<wordList.size();i++){

            if(i==0) {
                result = wordList.get(i);
                continue;
            }

            result = multiplyList(result, wordList.get(i));

        }

        result.stream().forEach(a -> output.append(a + " "));

    }


    private static List<String> multiplyList(List<String> list1, List<String> list2){
        List<String> newList = new ArrayList<>();
        for(int i=0; i<list1.size(); i++){
            for(int j=0; j<list2.size(); j++){
                newList.add(list1.get(i) + list2.get(j));
            }
        }

        return newList;
    }

}
