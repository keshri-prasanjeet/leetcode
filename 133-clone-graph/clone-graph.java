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
        Stack<Node> nodeStack = new Stack<>();
        Map<Node, Node> oldNew = new HashMap<>();
        Set<Node> visited = new HashSet<>();
        nodeStack.push(node);
        while(!nodeStack.isEmpty()){
            Node top = nodeStack.pop();
            if(visited.contains(top)) continue;
            if(!oldNew.containsKey(top)){
                Node newNode = new Node(top.val);
                oldNew.put(top, newNode);
            }
            for(Node n: top.neighbors){
                if(!visited.contains(n)){
                    nodeStack.push(n);
                }
            }
            visited.add(top);
        }
        visited.clear();
        nodeStack.push(node);
        while(!nodeStack.isEmpty()){
            Node top = nodeStack.pop();
            if(visited.contains(top)) continue;
            List<Node> newNeighbors = new ArrayList<>();
            for(Node n: top.neighbors){
                nodeStack.push(n);
                newNeighbors.add(oldNew.get(n));
            }
            oldNew.get(top).neighbors = newNeighbors;
            visited.add(top);
        }

        // for(Map.Entry<Node,Node> entry: oldNew.entrySet()){
        //     System.out.println(entry.getKey().neighbors + " " + entry.getValue().neighbors);
        // }
        
        return oldNew.get(node);
    }
}