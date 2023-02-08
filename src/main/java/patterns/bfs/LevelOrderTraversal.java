package patterns.bfs;

import patterns.ListNode;
import patterns.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given a binary tree, populate an array to represent its level-by-level traversal.
 * You should populate the values of all nodes of each level from left to right in separate sub-arrays.
 *              1
 *           2     3
 *          4 5   6 7
 *
 *
 * [[1], [2,3], [4,5,6,7]]
 */
public class LevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        one.left = two; one.right = three;
        two.left = four; two.right = five;
        three.left = six; three.right = seven;


        System.out.println(levelOrderTraversal(one));

        System.out.println(reverseLevelOrderTraversal(one));

    }

    private static List<List<Integer>> levelOrderTraversal(TreeNode root) {
        if(root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if(node.left != null) {
                    queue.add(node.left);
                }

                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(level);
        }

        return result;
    }

    private static List<List<Integer>> reverseLevelOrderTraversal(TreeNode root) {
        if(root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayDeque<List<Integer>> result = new ArrayDeque<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if(node.left != null) {
                    queue.add(node.left);
                }

                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            result.addFirst(level);

        }

        return new ArrayList<>(result);
    }
}
