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
    Integer prev;
    boolean answer;
    public boolean isValidBST(TreeNode root) {
        answer = true;
        doInorder(root);
        return answer;
    }

    private void doInorder(TreeNode node){
        if(node == null) return;
        doInorder(node.left);
        if(prev == null || prev < node.val){
            prev = node.val;
        }
        else answer = false;
        doInorder(node.right);
    }
}