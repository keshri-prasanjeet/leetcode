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
    int[] preorder;
    Map<Integer, Integer> InMap;
    int preIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;
        this.preorder = preorder;
        preIndex = 0;
        InMap = new HashMap<>();
        int index = 0;
        for(int i:inorder){
            InMap.put(i, index++);
        }
        return buildRealTree(0, inorder.length-1);
    }
    private TreeNode buildRealTree(int inStart, int inEnd){
        if(inEnd < inStart) return null;
        TreeNode node = new TreeNode(preorder[preIndex++]);
        int rootIndex = InMap.get(node.val);
        node.left = buildRealTree(inStart, rootIndex-1);
        node.right = buildRealTree(rootIndex+1, inEnd);
        return node;
    }
}