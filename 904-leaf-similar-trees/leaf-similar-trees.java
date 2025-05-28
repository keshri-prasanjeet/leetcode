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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaf1 = new ArrayList<>();
        List<Integer> leaf2 = new ArrayList<>();

        helper(root1, leaf1);
        helper(root2, leaf2);

        if(leaf1.size() != leaf2.size()) return false;
        for(int i=0;i<leaf1.size();i++){
            
            if(!leaf1.get(i).equals(leaf2.get(i))){
                return false;
            }
            
        }
        return true;
    }


    private void helper(TreeNode node, List<Integer> leaf){
        if(node == null) return;
        if(node.left == null && node.right == null) leaf.add(node.val);
        helper(node.left, leaf);
        helper(node.right, leaf);
    }
}