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
        if(root.left == null && root.right == null){
            path.append(root.val);
            answer.add(path.toString());
            return;
        }

        if(root.left != null){
            StringBuilder sb = new StringBuilder(path);
            sb.append(root.val).append("->");
            findPaths(root.left, sb);
        }

        if(root.right != null){
            StringBuilder sb = new StringBuilder(path);
            sb.append(root.val).append("->");
            findPaths(root.right, sb);
        }

    }
}