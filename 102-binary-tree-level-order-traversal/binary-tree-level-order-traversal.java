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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answerLiqueue = new ArrayList<>();
        if(root == null) return answerLiqueue;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> levelLiqueue = new ArrayList<>();
            while(size!=0){
                TreeNode top = queue.poll();
                if(top.left!=null) queue.offer(top.left);
                if(top.right!=null) queue.offer(top.right);
                levelLiqueue.add(top.val);
                size--;
            }
            answerLiqueue.add((levelLiqueue));
        }
        return answerLiqueue;
    }
}