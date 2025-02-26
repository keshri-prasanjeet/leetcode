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
    boolean answer = true;
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        doInorder(root);
        return answer;
    }
    private void doInorder(TreeNode node){
        if(node == null) return;
        doInorder(node.left);
        if(prev == null || prev.val < node.val){
            prev = node;
        }
        else{
            if(prev.val >= node.val) answer = false;
        }
        doInorder(node.right);
    }
}