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
    int globalMaxSum;
    public int maxPathSum(TreeNode root) {
        globalMaxSum = Integer.MIN_VALUE;
        findMaxPathSum(root);
        return globalMaxSum;
    }

    private int findMaxPathSum(TreeNode root){
        if(root == null) return 0;
        int left = Math.max(0,findMaxPathSum(root.left));
        int right = Math.max(0,findMaxPathSum(root.right));
        globalMaxSum = Math.max(globalMaxSum, left+right+root.val);
        return root.val + Math.max(left, right);
    }
}