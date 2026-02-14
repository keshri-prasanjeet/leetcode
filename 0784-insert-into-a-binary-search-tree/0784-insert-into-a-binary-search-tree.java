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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        if(root.val > val){
            root.left = insertIntoBST(root.left, val);
            // TreeNode leftNode = insertIntoBST(root.left, val);
            // if(leftNode == null) {
            //     root.left = new TreeNode(val);
            //     return root;
            // }
            return root;
        }
        else{
            root.right = insertIntoBST(root.right, val);
            // TreeNode rightNode= insertIntoBST(root.right,val);
            // if(rightNode == null){
            //     root.right = new TreeNode(val);
            //     return root;
            // }
            return root;
        }
        // return root;
    }
}