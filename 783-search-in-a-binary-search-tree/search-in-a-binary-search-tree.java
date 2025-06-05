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
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return root;
        if(root.val == val) return root;
        TreeNode leftNode = null;
        TreeNode rightNode = null;
        if(root.left!=null && val < root.val) leftNode = searchBST(root.left, val);
        if(root.right!=null && val > root.val) rightNode = searchBST(root.right, val);
        return leftNode == null ? rightNode: leftNode;
    }
}