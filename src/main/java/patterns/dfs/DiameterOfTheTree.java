package patterns.dfs;

import patterns.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary tree, find the length of its diameter.
 * The diameter of a tree is the number of nodes on the longest path between any two leaf nodes.
 * The diameter of a tree may or may not pass through the root.
 *
 * Note: You can always assume that there are at least two leaf nodes in the given tree.
 */
public class DiameterOfTheTree {
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

        System.out.println(findDiameter(one));

        test2();
    }

    private static void test2() {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);

        one.left = two; one.right = three;
        two.left = four; two.right = five;
        System.out.println(findDiameter(one));
    }

    private static int findDiameter(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Map<TreeNode, int[]> map = new HashMap<>();

        findDiameterUtil(root, map);

        int max = Integer.MIN_VALUE;
        while(root != null) {
            int[] heights = map.get(root);
            max = Math.max(max, 1 + heights[0] + heights[1]);

            if(heights[0] > heights[1]) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return max;
    }

    private static int findDiameterUtil(TreeNode root, Map<TreeNode, int[]> map) {
        if(root == null) {
            return 0;
        }

        int left = findDiameterUtil(root.left, map);
        int right = findDiameterUtil(root.right, map);

        map.put(root, new int[]{left, right});

        return 1 + Math.max(left, right);
    }


    // no need to re-iterate the array
    // diameter can be calculated at each step
    static int diameter = 0;
    private static int findDiameterRecursive(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = findDiameterRecursive(root.left);
        int right = findDiameterRecursive(root.right);

        diameter = Math.max(diameter, 1 + left + right);

        return 1 + Math.max(left, right);
    }
}
