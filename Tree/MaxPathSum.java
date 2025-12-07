/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) return 0;

        // Calculate gain from left and right but ignore negative paths
        int leftGain = Math.max(0, maxGain(node.left));
        int rightGain = Math.max(0, maxGain(node.right));

        // Path passing through this node (turning point)
        int priceNewPath = node.val + leftGain + rightGain;

        // Update global maximum
        maxSum = Math.max(maxSum, priceNewPath);

        // Return gain contributed *upwards* (choose only one side)
        return node.val + Math.max(leftGain, rightGain);
    }
}
