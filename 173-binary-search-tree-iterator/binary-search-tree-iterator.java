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
class BSTIterator {
    List<Integer> inorderList;
    int index;
    public BSTIterator(TreeNode root) {
        inorderList = new ArrayList<>();
        index = 0;
        doInorder(root);
    }

    private void doInorder(TreeNode root){
        if(root == null) return;
        doInorder(root.left);
        inorderList.add(root.val);
        doInorder(root.right);
    }
    
    public int next() {
        return inorderList.get(index++);
    }
    
    public boolean hasNext() {
        if(index < inorderList.size()) return true;
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */