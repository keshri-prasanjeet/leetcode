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
    int countGood = 0;
    public int goodNodes(TreeNode root) {
        findGood(root, Integer.MIN_VALUE);
        return countGood;
    }

    private void findGood(TreeNode node, int maxUntilNow){
        if(node == null) return;
        if(node.val >= maxUntilNow) countGood++;
        int maxHere = Math.max(node.val, maxUntilNow);
        findGood(node.left, maxHere);
        findGood(node.right,maxHere);
    }
}