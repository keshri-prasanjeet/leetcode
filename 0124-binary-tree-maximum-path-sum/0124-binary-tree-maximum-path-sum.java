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
    int maxFound = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        //each node can advertise the maximum sum possible at it
        // if you take me you get...
        // store left side, right side and current side
        // what is better, just taking left, or just taking right, 
        // or taking both, that means taking me as well
        pathSum(root);
        return maxFound;
    }

    private int pathSum(TreeNode root){
        if(root == null) return 0;
        System.out.println("At node " + root.val);
        int leftSide = pathSum(root.left);
        int rightSide= pathSum(root.right);
        System.out.println("left is " + leftSide + " right side is " + rightSide);
        int onlyRight = root.val + rightSide;
        int onlyLeft = root.val + leftSide;
        int maxSoFar = Math.max(onlyRight,Math.max(onlyLeft,root.val));
        int allThree = leftSide + rightSide  + root.val;
        System.out.println("allThree is " + allThree);
        maxFound = Math.max(allThree,Math.max(maxSoFar, maxFound));
        System.out.println("maxFoudn is " + maxFound);
        return maxSoFar;
    }
}