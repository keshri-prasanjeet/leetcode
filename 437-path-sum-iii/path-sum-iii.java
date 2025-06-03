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
    Map<Long, Integer> prefixSumMap;
    int count;
    public int pathSum(TreeNode root, int targetSum) {
        prefixSumMap = new HashMap<>();
        count = 0;
        prefixSumMap.put(0L,1);
        helper(root, targetSum, 0L);
        return count;
    }

    private void helper(TreeNode node, int target, long prefixSum){
        if(node == null) return;
        prefixSum+=node.val;
        count += prefixSumMap.getOrDefault(prefixSum - target, 0);
        prefixSumMap.put(prefixSum, prefixSumMap.getOrDefault(prefixSum,0)+1);
        helper(node.left, target, prefixSum);
        helper(node.right, target,prefixSum);
        prefixSumMap.put(prefixSum, prefixSumMap.get(prefixSum)-1);
        prefixSum-=node.val;
    }
}