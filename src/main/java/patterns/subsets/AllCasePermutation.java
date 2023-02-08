package patterns.subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string, find all of its permutations preserving the character sequence but changing case.
 * <p>
 * Example 1:
 * <p>
 * Input: "ad52"
 * Output: "ad52", "Ad52", "aD52", "AD52"
 */
public class AllCasePermutation {
    public static void main(String[] args) {
        System.out.println(findAllCase("Ad52"));
        System.out.println(findAllCase("ab7c"));
    }

    private static List<String> findAllCase(String str) {
        List<String> result = new ArrayList<>();
        char[] chars = str.toCharArray();
        char[] curr = new char[chars.length];

        findAllCaseUtil(chars, curr, result, 0);
        return result;
    }

    static void findAllCaseUtil(char[] str, char[] curr, List<String> result, int length) {
        if (length == str.length) {
            result.add(new String(curr));
            return;
        }

        int i = length;

        if ((str[i] >= 'a' && str[i] <= 'z')) {
            curr[i] = str[i];
            findAllCaseUtil(str, curr, result, i + 1);
            curr[i] = (char) ('A' + (str[i] - 'a'));
            findAllCaseUtil(str, curr, result, i + 1);
        } else if ((str[i] >= 'A' && str[i] <= 'Z')) {
            curr[i] = str[i];
            findAllCaseUtil(str, curr, result, i + 1);
            curr[i] = (char) ('a' + (str[i] - 'A'));
            findAllCaseUtil(str, curr, result, i + 1);
        } else {
            curr[i] = str[i];
            findAllCaseUtil(str, curr, result, i + 1);
        }
    }
}
