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
    int totalSum = 0;
    public int sumNumbers(TreeNode root) {
        // D R Y
        //preorder? keep adding the root and keep track of last added root
        doPreorderSum(root, 0);
        return totalSum;
    }
    private void doPreorderSum(TreeNode root, int val){
        if(root == null) return;
        val  = val * 10 + root.val;
        if(root.left == null && root.right == null){
            totalSum += val;
            return;
        }
        doPreorderSum(root.left, val);
        doPreorderSum(root.right, val);
    }
}