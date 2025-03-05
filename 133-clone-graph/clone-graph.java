/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return node;
        Queue<Node> nodeQ = new LinkedList<>();
        Map<Node, Node> oldNew = new HashMap<>();
        nodeQ.offer(node);
        oldNew.put(node, new Node(node.val));
        while(!nodeQ.isEmpty()){
            Node top = nodeQ.poll();
            for(Node neighbor: top.neighbors){
                if(!oldNew.containsKey(neighbor)){
                    oldNew.put(neighbor, new Node(neighbor.val));
                    nodeQ.add(neighbor);
                }
                oldNew.get(top).neighbors.add(oldNew.get(neighbor));
            }
        }
        return oldNew.get(node);
    }
}