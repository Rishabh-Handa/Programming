package patterns.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * For a given number ‘N’, write a function to generate all combination of ‘N’ pairs of balanced parentheses.
 *
 * Example 1:
 *
 * Input: N=2
 * Output: (()), ()()
 * Example 2:
 *
 * Input: N=3
 * Output: ((())), (()()), (())(), ()(()), ()()()
 */
public class OpenCloseParenthesis {
    public static void main(String[] args) {
        //System.out.println(printParenthesis(2));
        //System.out.println(printParenthesis(3));
        //System.out.println(printParenthesis(4));
        System.out.println(balanceParenthesis(3));
    }


    private static class Parenthesis {
        int open;
        int close;
        StringBuilder paren;

        public Parenthesis(int open, int close, StringBuilder paren) {
            this.open = open;
            this.close = close;
            this.paren = paren;
        }
    }
    private static  List<String> balanceParenthesis(int num) {
        List<String> result = new ArrayList<>();
        if(num <= 0) {
            return result;
        }
        Queue<Parenthesis> queue = new LinkedList<>();

        queue.offer(new Parenthesis(0,0, new StringBuilder()));

        while(!queue.isEmpty()) {
            Parenthesis paren = queue.poll();

            if(paren.open == num && paren.close == num) {
                result.add(paren.paren.toString());
            } else {
                if(paren.open < num) {
                    StringBuilder newParen = new StringBuilder(paren.paren);
                    newParen.append('(');
                    queue.offer(new Parenthesis(paren.open + 1, paren.close, newParen));
                }

                if(paren.close < paren.open) {
                    StringBuilder newParen = new StringBuilder(paren.paren);
                    newParen.append(')');
                    queue.offer(new Parenthesis(paren.open, paren.close + 1, newParen));
                }
            }
        }

        return result;
    }
    private static List<String> printParenthesis(int num) {
        List<String> result = new ArrayList<>();
        if(num <= 0) {
            return result;
        }
        int max = 2 * num;
        fillParenthesis(result, new char[max], 0, 0, 0, max);

        return result;
    }

    static void fillParenthesis(List<String> result, char[] parens, int open, int close, int size, int max) {
        if(size == max) {
            if(open == close) {
                result.add(new String(parens));
            }
            return;
        }

        if(close == 1) {
            close--;
            open--;
        }
        if(open < 0) {
            return;
        }
        if(size == 0) {
            parens[size] = '(';
            fillParenthesis(result, parens, open + 1, close, size + 1, max);
        } else {
            parens[size] = '(';
            fillParenthesis(result, parens, open + 1, close, size + 1, max);
            parens[size] = ')';
            fillParenthesis(result, parens, open, close + 1, size + 1, max);
        }
    }
}
