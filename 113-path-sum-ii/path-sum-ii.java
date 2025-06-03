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
        if(root == null) return finalAnswer;
        List<Integer> sumList = new ArrayList<>();
        helper(root, targetSum, sumList);
        return finalAnswer;
    }

    private void helper(TreeNode node, int target, List<Integer> sumList){
        if(node == null) return;
        target-=node.val;
        // if(newTarget < 0) return;
        sumList.add(node.val);
        if(target == 0 && node.left == null && node.right == null){
            finalAnswer.add(new ArrayList<>(sumList));
        }
        else{
            helper(node.left, target, sumList);
            helper(node.right, target, sumList);
        }

        sumList.remove(sumList.size()-1);
        
    }
}