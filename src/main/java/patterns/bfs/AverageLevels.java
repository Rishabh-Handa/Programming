package patterns.bfs;

import patterns.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, populate an array to represent the averages of all of its levels.
 */
public class AverageLevels {

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

        System.out.println(levelAverage(one));
    }

    private static List<Double> levelAverage(TreeNode root) {
        List<Double> result = new ArrayList<>();

        if(root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for(int i=0; i<size; i++) {
                TreeNode currNode = queue.poll();
                sum += currNode.val;

                if(currNode.left != null) {
                    queue.offer(currNode.left);
                }

                if(currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
            result.add(sum/size);
        }

        return result;
    }
}
