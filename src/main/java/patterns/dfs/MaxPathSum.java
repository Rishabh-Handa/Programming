package patterns.dfs;

import patterns.TreeNode;

import java.util.*;

public class MaxPathSum {
    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(8);
        TreeNode nine = new TreeNode(9);
        TreeNode ten = new TreeNode(10);
        TreeNode eleven = new TreeNode(11);

        one.left = two; one.right = three;
        three.left = five; three.right = six;
        five.left = seven; five.right = eight;
        eight.left = ten;
        six.right = nine;
        nine.right = eleven;

        System.out.println(findMaxSum(one));
    }

    static int diameter = 0;
    private static int findMaxSum(TreeNode root) {
        if(root == null) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        Queue<Integer> queue = new LinkedList<>();

        int left = findMaxSum(root.left);
        int right = findMaxSum(root.right);

        diameter = Math.max(diameter, root.val + left + right);

        return root.val + Math.max(left, right);
    }
}
