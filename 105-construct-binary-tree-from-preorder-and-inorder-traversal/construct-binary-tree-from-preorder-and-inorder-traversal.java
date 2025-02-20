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
    int[] pre;
    int preIndex;
    Map<Integer, Integer> inMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;
        this.pre = preorder;
        preIndex = 0;
        int index = 0;
        inMap = new HashMap<>();
        for(int i:inorder){
            inMap.put(i, index++);
        }
        return treeBuilder(0, inorder.length-1);
    }
    private TreeNode treeBuilder(int inStart, int inEnd){
        if(inStart > inEnd) return null;
        TreeNode newNode = new TreeNode(pre[preIndex++]);
        int nodeIndex = inMap.get(newNode.val);
        newNode.left = treeBuilder(inStart, nodeIndex-1);
        newNode.right = treeBuilder(nodeIndex+1, inEnd);
        return newNode;
    }
}