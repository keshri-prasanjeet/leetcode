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
    int maxDiameter;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;
        findDiameter(root);
        return maxDiameter;
    }
    private int findDiameter(TreeNode root){
        if(root == null) return 0;
        int left = findDiameter(root.left);
        int right = findDiameter(root.right);
        int maxChildren = Math.max(left, right);
        maxDiameter = Math.max(maxDiameter, left+right);
        return 1 + maxChildren;
    }
}