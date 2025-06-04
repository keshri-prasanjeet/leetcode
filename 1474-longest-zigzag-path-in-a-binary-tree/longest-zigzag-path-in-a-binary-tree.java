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
        int[] right = doZigZag(node.right);
        int[] left = doZigZag(node.left);

        int leftZigZag = 1 + left[1]; // left call's right(1) value
        int rightZigZag = 1 + right[0];//right call;s left(0) value
        maxZigZag = Math.max(maxZigZag, Math.max(leftZigZag, rightZigZag));
        return new int[]{leftZigZag, rightZigZag};
    }
}