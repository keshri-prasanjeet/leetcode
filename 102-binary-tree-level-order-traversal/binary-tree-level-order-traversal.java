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
    List<List<Integer>> levelOrderList;
    public List<List<Integer>> levelOrder(TreeNode root) {
        this.levelOrderList = new ArrayList<>();
        if(root == null) return levelOrderList;
        helper(0, root);
        return levelOrderList;
    }
    
    private void helper(int depth, TreeNode node){
        if(node == null) return;
        if(depth >= levelOrderList.size()) levelOrderList.add(new ArrayList<>(List.of(node.val)));
        else levelOrderList.get(depth).add(node.val);
        helper(depth+1, node.left);
        helper(depth+1, node.right);
    }
}