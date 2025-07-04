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
    int goodNodes;
    public int goodNodes(TreeNode root) {
        goodNodes = 0;
        helper(root, Integer.MIN_VALUE);
        return goodNodes;
    }

    private void helper(TreeNode root, int maxUntilNow){
        if(root==null) return;
        if(root.val >= maxUntilNow) goodNodes++;
        helper(root.left, Math.max(maxUntilNow, root.val));
        helper(root.right, Math.max(maxUntilNow, root.val));
    }
}