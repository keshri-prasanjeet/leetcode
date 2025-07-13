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
        Queue<Node> q = new LinkedList<>();
        Map<Node, Node> oldNew = new HashMap<>();
        q.offer(node);
        oldNew.put(node, new Node(node.val));
        while(!q.isEmpty()){
            Node poll = q.poll();
            for(Node neighbor: poll.neighbors){
                if(!oldNew.containsKey(neighbor)){
                    oldNew.put(neighbor, new Node(neighbor.val));
                    q.offer(neighbor);
                }
                oldNew.get(poll).neighbors.add(oldNew.get(neighbor));
            }
        }
        return oldNew.get(node);
    }
}