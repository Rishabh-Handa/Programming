package patterns.dfs;

import patterns.TreeNode;

/**
 * https://leetcode.com/problems/path-sum-iii/
 *
 * Given the root of a binary tree and an integer targetSum,
 * return the number of paths where the sum of the values along the path equals targetSum.
 *
 * The path does not need to start or end at the root or a leaf,
 * but it must go downwards (i.e., traveling only from parent nodes to child nodes).
 */
public class PathSumAnyRootAnyNode {
    public static void main(String[] args) {
        TreeNode ten = new TreeNode(10);
        TreeNode five = new TreeNode(5);
        TreeNode n3 = new TreeNode(-3);
        ten.left = five; ten.right = n3;

        TreeNode three = new TreeNode(3);
        TreeNode two = new TreeNode(2);
        five.left = three; five.right = two;

        TreeNode eleven = new TreeNode(11);
        n3.right = eleven;

        TreeNode three2 = new TreeNode(3);
        TreeNode n2 = new TreeNode(-2);
        three.left = three2; three.right = n2;

        TreeNode one = new TreeNode(1);
        two.right = one;

        System.out.println(pathSum(ten, 8));

        test2();

    }

    private static void test2() {
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

        System.out.println(pathSum(one, 12));
    }

    private static int pathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return 0;
        }
        return pathSumUtil(root, targetSum, false);
    }

    static int pathSumUtil(TreeNode root, int targetSum, boolean using) {
        if(root == null) {
            return 0;
        }

        int totalPaths = 0;
        if(root.val == targetSum) {
            return 1;
        }

        int useRootLeft = pathSumUtil(root.left, targetSum - root.val, true);
        int useRootRight = pathSumUtil(root.right, targetSum - root.val, true);

        int dontUseRootLeft = 0;
        int dontUseRootRight = 0;
        if(!using) {
            dontUseRootLeft = pathSumUtil(root.left, targetSum, false);
            dontUseRootRight = pathSumUtil(root.right, targetSum, false);
        }

        totalPaths = totalPaths + useRootLeft + useRootRight + dontUseRootLeft + dontUseRootRight;

        return totalPaths;
    }
}
