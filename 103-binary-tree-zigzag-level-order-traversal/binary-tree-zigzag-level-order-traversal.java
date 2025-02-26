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
    List<List<Integer>> zigZagLevelOrderList;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //do a regular traversal and then zigzagify them
        zigZagLevelOrderList = new ArrayList<>();
        if(root!=null) helper(0, root);
        boolean flag = false;
        for(int i=0;i<zigZagLevelOrderList.size();i++){
            if(flag == true){
                Collections.reverse(zigZagLevelOrderList.get(i));
                flag = false;
                continue;
            }
            flag = true;
        }
        return zigZagLevelOrderList;
    }
    private void helper(int depth, TreeNode node){
        if(node == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode head = queue.poll();
                level.add(head.val);
                if(head.left!=null) queue.add(head.left);
                if(head.right!=null) queue.add(head.right);
            }
            zigZagLevelOrderList.add(level);
        }
    }
}