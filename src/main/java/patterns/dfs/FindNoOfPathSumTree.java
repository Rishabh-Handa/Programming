package patterns.dfs;

import patterns.TreeNode;

/**
 * Given a binary tree and a number ‘S’,
 * find all paths from root-to-leaf such that the sum of all the node values of each path equals ‘S’.
 */
public class FindNoOfPathSumTree {

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(8);
        TreeNode nine = new TreeNode(9);
        one.left = two; one.right = three;
        two.left = four; two.right = five;
        three.left = six; three.right = seven;
        five.left = eight;
        six.right = nine;

        System.out.println(hasPathSum(one, 7));
    }

    public static int hasPathSum(TreeNode root, int targetSum) {
        return totalPathSum(root, targetSum, 0);
    }

    static int totalPathSum(TreeNode root, int targetSum, int totalPaths) {
        if(root == null) {
            return totalPaths;
        }

        if(root.left == null && root.right == null && 0 == (targetSum - root.val)) {
            return totalPaths + 1;
        }

        int checkLeft = hasPathSum(root.left, targetSum - root.val);
        int checkRight = hasPathSum(root.right, targetSum - root.val);

        return checkLeft + checkRight;
    }
}
