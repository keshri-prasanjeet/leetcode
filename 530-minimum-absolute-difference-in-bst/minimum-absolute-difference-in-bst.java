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
    int minAbsDiff;
    TreeNode prev;
    public int getMinimumDifference(TreeNode root) {
        minAbsDiff = Integer.MAX_VALUE;
        prev = null;
        doInorder(root);
        return minAbsDiff;
    }
    private void doInorder(TreeNode node){
        if(node == null) return;
        doInorder(node.left);
        if(prev!=null){
            minAbsDiff = Math.min(minAbsDiff, Math.abs(prev.val - node.val));
        }
        prev = node;
        doInorder(node.right);
    }
    
}