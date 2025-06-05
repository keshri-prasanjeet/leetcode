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
    public int maxLevelSum(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> treeQ = new LinkedList<>();
        Map<Integer,Integer> sumLevel = new HashMap<>();
        int maxLevelSum = Integer.MIN_VALUE;
        treeQ.offer(root);
        int level=1;
        while(!treeQ.isEmpty()){
            int size = treeQ.size();
            int sum = 0;
            while(size-- != 0){
                TreeNode top = treeQ.poll();
                if(top.left != null) treeQ.offer(top.left);
                if(top.right !=null) treeQ.offer(top.right);
                sum+=top.val;
            }
            // System.out.println("level is " + level + " sum is " + sum);
            maxLevelSum = Math.max(maxLevelSum, sum);
            if(!sumLevel.containsKey(sum)) sumLevel.put(sum, level++);
        }
        return sumLevel.get(maxLevelSum);
    }
}