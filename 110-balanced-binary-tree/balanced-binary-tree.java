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
    boolean answer;
    public boolean isBalanced(TreeNode root) {
        answer = true;
        findDepth(root);
        return answer;
    }

    private int findDepth(TreeNode root){
        if(answer == false) return 0;
        if(root == null) return 0;
        int leftDepth = findDepth(root.left);
        int rightDepth = findDepth(root.right);
        if(Math.abs(leftDepth - rightDepth) > 1) answer = false;
        return 1 + Math.max(leftDepth, rightDepth);
    }
}