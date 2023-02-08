package patterns.dfs;

import patterns.TreeNode;

/**
 * Given a binary tree and a number ‘S’, 
 * find if the tree has a path from root-to-leaf such that the sum of all the node values of that path equals ‘S’.
 */
public class PathSumTree {
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

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        }

        if(root.left == null && root.right == null) {
            return 0 == (targetSum - root.val);
        }

        boolean checkLeft = hasPathSum(root.left, targetSum - root.val);
        boolean checkRight = hasPathSum(root.right, targetSum - root.val);

        return checkLeft || checkRight;

    }
}
