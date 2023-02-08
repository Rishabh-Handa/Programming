package patterns.bfs;

import patterns.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Find the minimum depth of a binary tree. The minimum depth is
 * the number of nodes along the shortest path from the root node to the nearest leaf node.
 */
public class FindMinimumDepth {
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

        System.out.println(findMinDepth(one));
    }

    private static int findMinDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) {
            return 0;
        }

        int depth = 0;

        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0 ; i<size; i++) {
                TreeNode currNode = queue.poll();

                if (currNode.left == null && currNode.right == null) {
                    return depth + 1;
                }

                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }

                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }

            depth++;
        }

        return depth;
    }
}
