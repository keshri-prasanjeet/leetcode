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
    public List<Integer> rightSideView(TreeNode root) {
        //do bfs print first
        if(root == null) return List.of();
        List<Integer> answer = new ArrayList<>();
        Queue<TreeNode> treeQ = new LinkedList<>();
        treeQ.offer(root);
        // answer.add(root.val);
        while(!treeQ.isEmpty()){
            int size = treeQ.size();
            while(size-- != 0){
                TreeNode top = treeQ.poll();
                if(top.left!=null) treeQ.offer(top.left);
                if(top.right!=null) treeQ.offer(top.right);
                if(size == 0) answer.add(top.val);
            }
        }
        return answer;
    }
}