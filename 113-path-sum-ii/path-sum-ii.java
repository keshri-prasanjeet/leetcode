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
    List<List<Integer>> finalAnswer;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        finalAnswer = new ArrayList<>();
        helper(root, targetSum, new ArrayList<>());
        return finalAnswer;
    }

    private void helper(TreeNode node, int target, List<Integer> pathList){
        if(node == null) return;
        target-=node.val;
        pathList.add(node.val);
        if(target == 0 && node.left == null && node.right == null){
            finalAnswer.add(new ArrayList<>(pathList));
        }
        else{
            helper(node.left, target, pathList);
            helper(node.right,target, pathList);
        }
        pathList.remove(pathList.size() -1);
    }
}