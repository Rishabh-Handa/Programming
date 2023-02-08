package patterns.bfs;

import patterns.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree and a node, find the level order successor of the given node in the tree.
 * The level order successor is the node that appears right after the given node in the level order traversal.
 */
public class LevelOrderSuccessor {

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
        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        three.left = six;
        three.right = seven;
        five.left = eight;
        six.right = nine;

        System.out.println(findLevelOrderSuccessor(one, three));
    }

    private static TreeNode findLevelOrderSuccessor(TreeNode root, TreeNode node) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        boolean returnNext = false;
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            if (returnNext) {
                return currNode;
            }
            if (currNode.val == node.val) {
                returnNext = true;
            }

            if (currNode.left != null) {
                queue.offer(currNode.left);
            }

            if (currNode.right != null) {
                queue.offer(currNode.right);
            }

        }

        return null;
    }
}
