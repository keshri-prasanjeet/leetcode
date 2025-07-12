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
    List<String> answer;
    public List<String> binaryTreePaths(TreeNode root) {
        answer = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        findPaths(root, path);
        return answer;
    }

    private void findPaths(TreeNode root, StringBuilder path){
        if(root == null) return;
        int lenBeforeAddingCurrent = path.length();
        path.append(root.val);

        if(root.left == null && root.right == null){
            answer.add(path.toString());
        }
        else{
            path.append("->");
            findPaths(root.left, path);
            findPaths(root.right,path);
        }
        path.setLength(lenBeforeAddingCurrent);
    }
}