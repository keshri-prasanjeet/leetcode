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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lceNode = LCE(root, startValue, destValue);
        StringBuilder startPath = new StringBuilder();
        StringBuilder destPath = new StringBuilder();
        StringBuilder result = new StringBuilder();
        buildPath(lceNode, startValue, startPath);
        buildPath(lceNode,  destValue, destPath );

        for(int i=0;i<startPath.length();i++){
            result.append("U");
        }
        result.append(destPath);
        return result.toString();
        
    }

    private TreeNode LCE(TreeNode root, int startValue, int destValue){
        if(root == null || root.val == startValue || root.val == destValue) return root;
        TreeNode leftNode = LCE(root.left, startValue, destValue);
        TreeNode rightNode= LCE(root.right,startValue, destValue);
        if(leftNode != null && rightNode != null) return root;
        return leftNode != null ? leftNode : rightNode;
    }

    private boolean buildPath(TreeNode node, int target, StringBuilder path){
        if(node == null) return false;
        if(node.val == target) return true;

        path.append("L");
        if(buildPath(node.left, target, path)) return true;
        path.setLength(path.length()-1);


        path.append("R");
        if(buildPath(node.right, target, path)) return true;
        path.setLength(path.length()-1);

        return false;
    }
}