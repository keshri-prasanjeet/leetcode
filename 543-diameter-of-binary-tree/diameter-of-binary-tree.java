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
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root){
        diameterOfBinaryTree2(root);
        return maxDiameter;
    }
    public int diameterOfBinaryTree2(TreeNode root) {
        if(root == null) return 0;
        int right = diameterOfBinaryTree2(root.right);
        int left = diameterOfBinaryTree2(root.left);
        maxDiameter = Math.max(maxDiameter, right+left);
        return 1 + Math.max(right,left);
    }
}