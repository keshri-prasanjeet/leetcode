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
    List<TreeNode> preorderTree = new ArrayList<>();
    public void flatten(TreeNode root) {
        //do preorder
        if(root==null) return;
        doPreorder(root);
        TreeNode dummy = new TreeNode();
        for(TreeNode pointer: preorderTree){
            dummy.left = null;
            dummy.right = pointer;
            dummy = dummy.right;
        }
    }

    private void doPreorder(TreeNode node){
        if(node == null) return;
        preorderTree.add(node);
        doPreorder(node.left);
        doPreorder(node.right);
    }
}