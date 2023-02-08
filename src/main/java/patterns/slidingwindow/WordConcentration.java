package patterns.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Words Concatenation (hard) #
 * Given a string and a list of words,
 * find all the starting indices of substrings in the given string that are
 * a concatenation of all the given words exactly once without any overlapping of words.
 * It is given that all words are of the same length.
 *
 * Example 1:
 *
 * Input: String="catfoxcat", Words=["cat", "fox"]
 * Output: [0, 3]
 * Explanation: The two substring containing both the words are "catfox" & "foxcat".
 */
public class WordConcentration {
    public static void main(String[] args) {
        System.out.println(findWords("catfoxcat", new String[]{"cat", "fox"}));
    }

    private static List<Integer> findWords(String s, String[] words) {
        Map<String, Integer> stringMap = new HashMap<>();

        for(int i=0; i<words.length; i++) {
            stringMap.put(words[i], stringMap.getOrDefault(words[i], 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        int matched = 0;

        int wordLen = words[0].length();

        int left = 0;

        for(int right=0; right <= s.length() - wordLen; right = right + wordLen) {
            String currWord = s.substring(right, right + wordLen);
            if(stringMap.containsKey(currWord)) {
                stringMap.put(currWord, stringMap.get(currWord) - 1);
            }

            if(matched == stringMap.size()) {

            }
        }
        return null;
    }

    static boolean isValid(Map<String, Integer> stringMap) {
        for(String key: stringMap.keySet()) {
            //if()
        }

        return false;
    }
}
