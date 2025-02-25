/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Set<TreeNode> pAncestors;
    TreeNode lowestCommon;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        pAncestors = new HashSet<>();
        this.lowestCommon = null;
        findAncestors(root, p);
        for(TreeNode itr: pAncestors){
            System.out.println(itr.val);
        }
        findLowestCommon(root, q);
        return lowestCommon;
    }
    private boolean findAncestors(TreeNode node, TreeNode target){
        if(node == null) return false;
        if(node.val == target.val) {
            pAncestors.add(node);
            return true;
        }
        boolean left = findAncestors(node.left, target);
        boolean right= findAncestors(node.right, target);
        boolean isAncestor  = left || right;
        if(isAncestor){
            pAncestors.add(node);
        }
        return isAncestor;
    }

    private boolean findLowestCommon(TreeNode node, TreeNode target){
        if(node == null) return false;
        // System.out.println("At node " + node.val);
        if(node.val == target.val) {
            if(pAncestors.contains(node)){
                // System.out.println("ancestor is also p ancestor");
                lowestCommon = node;
                return false;
            }
            return true;
        }
        boolean isAncestor = findLowestCommon(node.left, target) || findLowestCommon(node.right, target);
        if(isAncestor){
            // System.out.println("found an ancestor " + node.val);
            if(pAncestors.contains(node)){
                // System.out.println("ancestor is also p ancestor");
                lowestCommon = node;
                return false;
            }
        }
        return isAncestor;
    }
    
}