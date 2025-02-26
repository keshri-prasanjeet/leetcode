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
    List<Double> levelAverageList;
    Map<Integer, Integer> lengthOfLevel;
    public List<Double> averageOfLevels(TreeNode root) {
        levelAverageList = new ArrayList<>();
        lengthOfLevel = new HashMap<>();
        if(root == null) return levelAverageList;
        levelOrderTraversal(0, root);
        for(int i=0;i<levelAverageList.size();i++){
            double val = levelAverageList.get(i);
            val /= (double)lengthOfLevel.get(i);
            levelAverageList.set(i, val);
        }
        return levelAverageList;
    }
    private void levelOrderTraversal(int depth, TreeNode root){
        if(root == null) return;
        if(depth >= levelAverageList.size()) {
            lengthOfLevel.put(depth, lengthOfLevel.getOrDefault(depth,0)+1);
            levelAverageList.add((double)root.val);
        }
        else {
            double val = levelAverageList.get(depth);
            val+=(double) root.val;
            levelAverageList.set(depth, val);
            lengthOfLevel.put(depth, lengthOfLevel.get(depth)+1);
        }
        levelOrderTraversal(depth+1, root.left);
        levelOrderTraversal(depth+1, root.right);
    }
}