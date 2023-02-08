package patterns.twopointers;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given two strings containing backspaces (identified by the character ‘#’), check if the two strings are equal.
 *
 * Example 1:
 *
 * Input: str1="xy#z", str2="xzz#"
 * Output: true
 * Explanation: After applying backspaces the strings become "xz" and "xz" respectively.
 */
public class StringBackspaces {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('a');
        stringBuilder.append('b');

        stringBuilder.insert(0, "hello");
        System.out.println(stringBuilder.toString());

        build("xy#z");

        System.out.println(compareStrings("xy#z", "xzz#"));
        System.out.println(compareStrings("xy#z", "xyz#"));
        System.out.println(compareStrings("xp#", "xyz##"));
        System.out.println(compareStrings("xywrrmp", "xywrrmu#p"));

        System.out.println("-----------");
        System.out.println(compareStrings2("xy#z", "xzz#"));
        System.out.println(compareStrings2("xy#z", "xyz#"));
        System.out.println(compareStrings2("xp#", "xyz##"));
        System.out.println(compareStrings2("xywrrmp", "xywrrmu#p"));
    }

    private static boolean compareStrings2(String s1, String s2) {
        int i = s1.length() - 1;
        int j = s2.length() - 1;

        while(i>=0 && j>=0) {
            i = getNext(s1, i);
            j = getNext(s2, j);

            if(i < 0 && j < 0) {
                return true;
            }

            if(i < 0 || j < 0) {
                return false;
            }

            if(s1.charAt(i) != s2.charAt(j)) {
                return false;
            }

            i--;
            j--;
        }
        return true;
    }

    static int getNext(String s, int i) {
        int b = 0;
        while(i >= 0) {
            if(s.charAt(i) == '#'){
                b++;
                i--;
            } else if(b > 0) {
                b--;
                i--;
            } else {
                return i;
            }
        }

        return i;
    }

    public static String build(String S) {
        Stack<Character> ans = new Stack();
        for (char c: S.toCharArray()) {
            if (c != '#')
                ans.push(c);
            else if (!ans.empty())
                ans.pop();
        }
        return String.valueOf(ans);
    }
    private static boolean compareStrings(String s1, String s2) {
        List<Integer> s1DiscardList = new ArrayList<>();
        List<Integer> s2DiscardList = new ArrayList<>();

        for(int i=0; i<s1.length(); i++) {
            if(s1.charAt(i) == '#') {
                int input = i;
                s1DiscardList.add(i);
                while(s1DiscardList.contains(input)) input--;
                s1DiscardList.add(input);
            }
        }

        for(int i=0; i<s2.length(); i++) {
            if(s2.charAt(i) == '#') {
                int input = i;
                s2DiscardList.add(i);
                while(s2DiscardList.contains(input)) input--;
                s2DiscardList.add(input);
            }
        }
        int i,j;
        for(i=0,j=0; i<s1.length() && j<s2.length();) {
            while(s1DiscardList.contains(i)) i++;
            while(s2DiscardList.contains(j)) j++;

            if(i<s1.length() && j<s2.length() && s1.charAt(i) != s2.charAt(j)) {
                return false;
            } else if(i<s1.length() && j<s2.length() && s1.charAt(i) == s2.charAt(j)){
                i++;
                j++;
            }
        }
        while(s1DiscardList.contains(i)) i++;
        while(s2DiscardList.contains(j)) j++;

        return i == s1.length() && j == s2.length();
    }
}
