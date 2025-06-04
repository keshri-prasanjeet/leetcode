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
    int maxZigZag = 0;
    public int longestZigZag(TreeNode root) {
        doZigZag(root);
        return maxZigZag-1;
    }

    private int[] doZigZag(TreeNode node){
        if(node == null) return new int[]{0,0};

        int[] left = doZigZag(node.left);
        int[] right= doZigZag(node.right);

        int leftMax = 1 + left[1];
        int rightMax= 1+ right[0];

        maxZigZag = Math.max(maxZigZag, Math.max(leftMax, rightMax));
        return new int[]{leftMax, rightMax};
    }
}