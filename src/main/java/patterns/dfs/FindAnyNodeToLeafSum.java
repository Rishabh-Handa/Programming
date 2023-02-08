package patterns.dfs;

import patterns.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a number ‘S’,
 * find all paths in the tree such that the sum of all the node values of each path equals ‘S’.
 * Please note that the paths can start or end at any node but all paths must follow direction
 * from parent to child (top to bottom).
 */
public class FindAnyNodeToLeafSum {
    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode seven = new TreeNode(7);
        TreeNode nine = new TreeNode(9);
        one.left = seven; one.right = nine;

        TreeNode six = new TreeNode(6);
        TreeNode five = new TreeNode(5);
        seven.left = six; seven.right = five;

        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        nine.left = two; nine.right = three;

        System.out.println(findList(one, 12));
    }

    private static List<List<Integer>> findList(TreeNode root, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        findListHelper(root, k, new ArrayList<>(), result);
        return result;
    }

    private static void findListHelper(TreeNode root, int k, ArrayList<Integer> currList,
                                       List<List<Integer>> result) {
        currList.add(root.val);
        if(root.left == null && root.right == null) {
            int sum = 0;
            List<Integer> tempList = new ArrayList<>(currList);
            for(int i: tempList) {
                sum += i;
            }
            while(!tempList.isEmpty()) {
                if(sum == k) {
                    result.add(tempList);
                    break;
                }
                sum -= tempList.get(0);
                tempList.remove(0);
            }
        }

        if(root.left != null) {
            findListHelper(root.left, k, currList, result);
            currList.remove(currList.size() - 1);
        }

        if(root.right != null) {
            findListHelper(root.right, k, currList, result);
            currList.remove(currList.size() - 1);
        }
    }
}
