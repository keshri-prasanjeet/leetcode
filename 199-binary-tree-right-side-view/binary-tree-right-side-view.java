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
    List<Integer> answer;
    public List<Integer> rightSideView(TreeNode root) {
        answer = new ArrayList<>();
        helper(0, root);
        return answer;
    }
    private void helper(int level, TreeNode root){
        if(root == null) return;
        if(level >= answer.size()) answer.add(root.val);
        answer.set(level,root.val);
        helper(level+1, root.left);
        helper(level+1, root.right);
    }
}