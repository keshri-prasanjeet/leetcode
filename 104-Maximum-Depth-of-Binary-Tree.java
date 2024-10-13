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
    int maxDepth;
    public int maxDepth(TreeNode root) {
        this.maxDepth = 0;
        findDepth(root,0);
        return maxDepth;
    }

    void findDepth(TreeNode root, int depth){
        if(root==null){
            maxDepth = Math.max(depth, maxDepth);
            return;
        }
        
        findDepth(root.left, depth+1);
        findDepth(root.right, depth+1);

        return;
        
    }
}