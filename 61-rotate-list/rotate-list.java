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
    public ListNode rotateRight(ListNode head, int k) {
        int len = 0;
        if(head==null || head.next==null) return head;
        ListNode pointer = head;
        while(pointer!=null){
            len++;
            pointer = pointer.next;
        }
        k = k%len;//effective rotation
        pointer = head;
        int loop = len - k -1;
        while(loop>0){
            pointer = pointer.next;
            loop--;
        }
        if(pointer.next == null) return head;
        ListNode newHead = pointer.next;
        pointer.next = null;
        pointer = newHead;
        while(pointer.next !=null){
            pointer = pointer.next;
        }
        pointer.next = head;
        return newHead;
    }
}