package epam;

/**
 * A path in a binary tree is a sequence of nodes where each pair of
 * adjacent nodes in the sequence has an edge connecting them.
 * A node can only appear in the sequence at most once. Note that the
 * path does not need to pass through the root.
 *
 * The path sum of a path is the sum of the node's values in the path.
 *
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 */
public class PathSum {

    static class Tree {
        int val;
        Tree left;
        Tree right;

        Tree(int val) {
            this.val = val;
        }
    }

    static int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Tree root = new Tree(-10);
        Tree nine = new Tree(90);
        Tree twenty = new Tree(20);
        Tree fifteen = new Tree(-15);
        Tree seven = new Tree(17);
        Tree five = new Tree(5);

//        root.left = nine;
//        root.right = twenty;
//        twenty.left = fifteen;
//        twenty.right = seven;
//        seven.left = five;

        findMaxSum(root);

        System.out.println(maxSum);
    }

    private static int findMaxSum(Tree root) {
       if(root == null) {
           return 0;
       }

       int leftSum = findMaxSum(root.left);
       int rightSum = findMaxSum(root.right);

       int totalSum = root.val + leftSum + rightSum;

       if(totalSum > maxSum) {
           maxSum = totalSum;
       }

       int l = root.val + leftSum;
       int r = root.val + rightSum;

       if(l > r) {
           return l;
       } else {
           return r;
       }
    }


}
