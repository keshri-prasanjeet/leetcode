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
};
*/

class Solution {
    List<Integer> answer;
    public List<Integer> preorder(Node root) {
        answer = new ArrayList<>();
        findPreorder(root);
        return answer;
    }

    private void findPreorder(Node node){
        if(node == null) return;
        answer.add(node.val);
        for(Node child: node.children){
            findPreorder(child);
        }
    }
}