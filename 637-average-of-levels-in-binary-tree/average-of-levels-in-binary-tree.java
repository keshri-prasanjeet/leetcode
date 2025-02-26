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
    List<List<Integer>> levelOrderList;
    public List<Double> averageOfLevels(TreeNode root) {
        levelAverageList = new ArrayList<>();
        levelOrderList = new ArrayList<>();
        if(root == null) return levelAverageList;
        levelOrderTraversal(0, root);
        System.out.println(levelOrderList);
        for(List<Integer> l: levelOrderList){
            double sum =0;
            for(Integer val: l){
                sum+=val;
            }
            double avg = sum / (double)l.size();
            levelAverageList.add(avg);
        }
        return levelAverageList;
    }
    private void levelOrderTraversal(int depth, TreeNode root){
        if(root == null) return;
        if(depth >= levelOrderList.size()) levelOrderList.add(new ArrayList<>(List.of(root.val)));
        else levelOrderList.get(depth).add(root.val);
        levelOrderTraversal(depth+1, root.left);
        levelOrderTraversal(depth+1, root.right);
    }
}