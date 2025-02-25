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
    int maxPathSum;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        maxPathSum = Integer.MIN_VALUE;
        findMaxPathSum(root);
        return maxPathSum;
    }
    private int findMaxPathSum(TreeNode node){
        if(node == null) return 0;
        int left = Math.max(0,findMaxPathSum(node.left));
        int right = Math.max(0,findMaxPathSum(node.right));
        int maxSumOfChildren = Math.max(left, right);
        maxPathSum = Math.max(maxPathSum, left + right + node.val);
        return node.val + maxSumOfChildren;
    }
}