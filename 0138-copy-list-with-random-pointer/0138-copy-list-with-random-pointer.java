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
        Map<Node, Node> oldNew = new HashMap<>();
        Node sentinel = new Node(0);
        Node pointer = sentinel;
        Node hPointer = head;
        while(hPointer!=null){
            pointer.next = new Node(hPointer.val);
            pointer = pointer.next;
            oldNew.put(hPointer, pointer);
            hPointer = hPointer.next;//moving the old list pointer
        }

        pointer.next = null;//terminating the new list

        hPointer = head;
        while(hPointer!=null){
            oldNew.get(hPointer).random = oldNew.get(hPointer.random);
            hPointer = hPointer.next;
        }

        return sentinel.next;
    }
}