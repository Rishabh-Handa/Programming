package patterns.dfs;

import patterns.TreeNode;

/**
 * Problem Statement #
 * Given a binary tree where each node can only have a digit (0-9) value,
 * each root-to-leaf path will represent a number. Find the total sum of all the numbers represented by all paths.
 */
public class SumOfPaths {
    public static void main(String[] args) {
        TreeNode nine2 = new TreeNode(9);
        TreeNode two = new TreeNode(2);
        TreeNode nine = new TreeNode(9);
        nine.left = two; nine.right = nine2;
        TreeNode seven = new TreeNode(7);
        TreeNode one = new TreeNode(1);
        one.left = seven; one.right = nine;

        System.out.println(findSum(one));

    }

    private static int findSum(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return findSumUtil(root, 0);
    }

    private static int findSumUtil(TreeNode root, int sum) {
        if(root == null) {
            return 0;
        }

        if(root.left == null && root.right == null) {
            return sum + root.val;
        }

        int leftSum = findSumUtil(root.left, (sum + root.val) * 10);
        int rightSum = findSumUtil(root.right, (sum + root.val) * 10);

        return leftSum + rightSum;
    }
}
