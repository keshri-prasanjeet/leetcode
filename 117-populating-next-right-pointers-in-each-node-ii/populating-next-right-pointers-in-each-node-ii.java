/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    List<List<Node>> levelOrderList = new ArrayList<>();
    public Node connect(Node root) {
        levelOrderTraversal(root, 0);
        for(List<Node> l: levelOrderList){
            Node prev = null;
            for(int i=l.size()-1;i>=0;i--){
                l.get(i).next = prev;
                prev = l.get(i);
            }
        }
        return root;
    }

    private void levelOrderTraversal(Node node, int level){
        if(node == null) return;
        if(levelOrderList.size() == 0 || levelOrderList.size() <= level){
            levelOrderList.add(new ArrayList<>(List.of(node)));
        }
        else{
            levelOrderList.get(level).add(node);
        }
        levelOrderTraversal(node.left, level+1);
        levelOrderTraversal(node.right, level+1);
    }
}