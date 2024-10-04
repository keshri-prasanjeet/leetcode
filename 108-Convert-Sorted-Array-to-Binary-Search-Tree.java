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
    public TreeNode sortedArrayToBST(int[] nums) {
        
        return treeBuilder(0, nums.length-1, nums);

    }

    private TreeNode treeBuilder(int startIndex, int endIndex, int[] nums){
        if(startIndex > endIndex) return null;
        int mid = startIndex + (endIndex-startIndex)/2;
        TreeNode newNode = new TreeNode(nums[mid]);

        newNode.left = treeBuilder(startIndex, mid-1, nums);
        newNode.right= treeBuilder(mid+1,endIndex, nums);

        return newNode;
    }
}