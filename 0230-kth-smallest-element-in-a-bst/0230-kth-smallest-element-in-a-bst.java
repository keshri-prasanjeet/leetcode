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
    int globalK;
    int kthSmallestNum = Integer.MAX_VALUE;
    public int kthSmallest(TreeNode root, int k) {
        globalK = k;
        findKth(root);
        return kthSmallestNum;
    }

    private void findKth(TreeNode node){
        if(node == null) return;
        findKth(node.left);
        globalK--;
        if(globalK == 0) kthSmallestNum = node.val;
        findKth(node.right);
    }
}