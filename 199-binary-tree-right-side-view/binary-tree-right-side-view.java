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
    List<Integer> rightSideList;
    public List<Integer> rightSideView(TreeNode root) {
        this.rightSideList = new ArrayList<>();
        if(root == null) return rightSideList;
        findRightSideView(0, root);
        return rightSideList;
    }
    private void findRightSideView(int depth, TreeNode node){
        if(node == null) return;
        if(depth >= rightSideList.size()) rightSideList.add(node.val);
        findRightSideView(depth+1, node.right);
        findRightSideView(depth+1, node.left);
    }
}