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
    List<List<Integer>> answer;
    public List<List<Integer>> levelOrder(TreeNode root) {
        answer=new ArrayList<>();
        if(root == null) return answer;
        helper(root, 0);
        return answer;
    }

    private void helper(TreeNode root, int level){
        if(root == null) return;
        if(answer.size() <= level) answer.add(new ArrayList<>());
        answer.get(level).add(root.val);
        helper(root.left, level+1);
        helper(root.right,level+1);
    }
}