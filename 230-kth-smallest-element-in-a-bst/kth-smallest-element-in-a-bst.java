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
    int answer;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        if(root!=null) doInorder(root, k);
        return answer;
    }
    private void doInorder(TreeNode root, int k){
        if(root == null) return;
        doInorder(root.left, k);
        count++;
        if(count == k) answer = root.val;
        doInorder(root.right,k);
    }
}