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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if(root == null) return answer;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            while(size > 0){
                TreeNode top = queue.poll();
                if(top.left!=null) queue.offer(top.left );
                if(top.right!=null)queue.offer(top.right);
                level.add(top.val);
                size--;
            }
            answer.add(new ArrayList<>(level));
        }
        boolean dir = false;
        for(List<Integer> inner:answer){
            if(true == dir){
                Collections.reverse(inner);
                dir=!dir;
            }
            else dir = true;
        }


        return answer;
    }
}