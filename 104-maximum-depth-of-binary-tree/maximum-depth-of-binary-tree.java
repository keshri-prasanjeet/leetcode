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
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return Math.max(findDepth(root.left), findDepth(root.right));
    }
    private int findDepth(TreeNode node){
        if(node==null) return 1;
        return 1 + (Math.max(findDepth(node.left), findDepth(node.right)));
    }
}