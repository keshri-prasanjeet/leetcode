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
    int maxPathSum = 0;
    Map<Long, Integer> pathSumMap;
    public int pathSum(TreeNode root, int targetSum) {
        pathSumMap = new HashMap<>();
        pathSumMap.put(0L,1);
        doPathSum(root, targetSum, 0L);
        return maxPathSum;
    }

    private void doPathSum(TreeNode node, int target, long pathSum){
        if(node == null) return;

        pathSum+=node.val;
        maxPathSum+=pathSumMap.getOrDefault(pathSum - target, 0);
        pathSumMap.put(pathSum, pathSumMap.getOrDefault(pathSum, 0)+1);
        doPathSum(node.left, target, pathSum);
        doPathSum(node.right,target, pathSum);
        pathSumMap.put(pathSum, pathSumMap.get(pathSum)-1);
    }
}