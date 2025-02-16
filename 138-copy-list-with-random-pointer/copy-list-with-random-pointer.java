/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> oldNew  = new HashMap<>();
        Node dummy = new Node(0);
        Node pointer = dummy;
        Node hPointer = head;
        while(hPointer!=null){
            pointer.next = new Node(hPointer.val);
            pointer = pointer.next;
            oldNew.put(hPointer, pointer);
            hPointer = hPointer.next;
        }
        hPointer = head;
        pointer = dummy.next;
        while(hPointer!=null){
            if(hPointer.random == null){
                pointer.random = null;
            }
            else{
                Node randomNode = hPointer.random;
                pointer.random = oldNew.get(randomNode);
            }
            hPointer = hPointer.next;
            pointer = pointer.next;
        }
        return dummy.next;
    }
}