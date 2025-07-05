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
    int gK;
    int ksm;
    boolean set = false;
    public int kthSmallest(TreeNode root, int k) {
        gK = k;
        ksm = -1;
        findKth(root);
        return ksm;
    }

    private void findKth(TreeNode node){
        if(node == null) return;
        findKth(node.left);
        gK--;
        if(gK == 0){
            ksm = node.val;
        }
        findKth(node.right);
    }
}