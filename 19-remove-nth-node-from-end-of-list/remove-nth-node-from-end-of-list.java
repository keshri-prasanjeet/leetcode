/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pointer = head;
        int totalNodes = 0;
        ListNode prevNode = null;
        while(pointer!=null){
            prevNode = pointer;
            pointer = pointer.next;
            totalNodes++;
        }
        if(totalNodes <=n) return head.next;
        int nodeToDelete = totalNodes - n;
        pointer = head;
        while(nodeToDelete!=1){
            pointer = pointer.next;
            nodeToDelete--;
        }
        pointer.next = pointer.next.next;
        return head;
    }
}