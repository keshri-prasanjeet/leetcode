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
    List<List<Integer>> answerList;
    public List<List<Integer>> levelOrder(TreeNode root) {
        answerList = new ArrayList<>();
        if(root == null) return answerList;
        helper(0, root);
        return answerList;
    }

    private void helper(int level, TreeNode node){
        if(node == null) return;
        if(level >= answerList.size()) answerList.add(new ArrayList<Integer>());
        answerList.get(level).add(node.val);
        helper(level+1, node.left);
        helper(level+1, node.right);
    }
}