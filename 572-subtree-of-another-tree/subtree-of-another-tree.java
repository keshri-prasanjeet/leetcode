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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //greedily go for a node that has the same root value as the subRoot
        //then just do same tree

        if(root==null && subRoot == null) return true;
        if(root==null || subRoot==null) return false;
        if(root.val == subRoot.val){
            System.out.println("found");
            boolean ans = sameTree(root, subRoot);
            if(ans == true) return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean sameTree(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null) return true;
        if(node1 == null || node2 == null) return false;
        System.out.println(node1.val + " " + node2.val);
        if(node1.val != node2.val) return false;
        return sameTree(node1.left, node2.left) && sameTree(node1.right, node2.right);
    }
}