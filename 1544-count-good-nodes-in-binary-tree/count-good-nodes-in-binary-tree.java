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
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int max){
        if(node == null) return 0;

        max = Math.max(max, node.val);

        if(node.val >= max){
            return 1 + dfs(node.left, max) + dfs(node.right, max);
        }
        else return dfs(node.left, max) + dfs(node.right, max);
    }
}