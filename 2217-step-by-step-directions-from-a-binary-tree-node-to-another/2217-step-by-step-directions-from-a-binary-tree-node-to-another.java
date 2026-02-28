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
        TreeNode lcaNode = LCA(root, startValue, destValue);
        if(lcaNode == null) return "";
        StringBuilder rightPath = new StringBuilder();
        StringBuilder leftPath =  new StringBuilder();
        StringBuilder finalPath = new StringBuilder();
        buildPath(lcaNode, rightPath, startValue);
        int rightLen = rightPath.length();
        rightPath.setLength(0);
        for(int i=0;i<rightLen;i++){
            rightPath.append("U");
        }
        buildPath(lcaNode, leftPath, destValue);
        rightPath.append(leftPath);
        return rightPath.toString();
    }

    private TreeNode LCA (TreeNode node, int startVal, int destVal){
        if(node == null || node.val == startVal || node.val == destVal) return node;
        TreeNode leftNode =  LCA(node.left , startVal, destVal);
        TreeNode rightNode = LCA(node.right, startVal, destVal);
        if(leftNode != null && rightNode != null) return node;
        return leftNode != null? leftNode : rightNode;
    }

    private boolean buildPath(TreeNode node, StringBuilder pathSb, int target){
        if(node == null) return false;
        if(node.val == target) return true;

        // we will explore left
        pathSb.append("L");
        if(buildPath(node.left, pathSb, target)) return true;
        //if we reached this part that mean left side did not have target
        //reset the pathSb
        pathSb.setLength(pathSb.length()-1);

        // we will explore the right
        pathSb.append("R");
        if(buildPath(node.right, pathSb, target)) return true;
        //if rigth was a disapointment then rest pathSb
        pathSb.setLength(pathSb.length()-1);

        return false;
    }


}