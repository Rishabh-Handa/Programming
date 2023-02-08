package epam;

import java.util.*;

/**
 * Group Anagrams:

 * Given an array of strings strs , group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly once.
 *

 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class Main {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat", "EAT"};
        Map<String, List<String>> resultMap = new HashMap<>();

        // O(N)
        for(String str: strs) {
            char[] chars = str.toCharArray();

            // O(1)
            Arrays.sort(chars);

            String key = new String(chars);
            key = key.toLowerCase(Locale.ROOT);

            List<String> mapValue = resultMap.get(key);
            if(mapValue == null) {
                mapValue = new ArrayList<>();
                mapValue.add(str);


                resultMap.put(key, mapValue);
            } else {
                mapValue.add(str);
            }
        }

        System.out.println(resultMap.values());
    }
}
