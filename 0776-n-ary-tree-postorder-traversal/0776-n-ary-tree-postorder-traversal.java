/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
*/

class Solution {
    List<Integer> answer;
    public List<Integer> postorder(Node root) {
        answer = new ArrayList<>();
        doPostorder(root);
        return answer;
    }

    private void doPostorder(Node node){
        if(node == null) return;
        for(Node child: node.children){
            doPostorder(child);
        }
        answer.add(node.val);
    }
}