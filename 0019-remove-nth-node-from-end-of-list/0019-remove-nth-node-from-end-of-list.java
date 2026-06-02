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
        int length = 0;

        ListNode temp = head;
        while(temp!=null){
            temp = temp.next;
            length++;
        }
        if(length <= 1) return null;
        length-=n;
        ListNode sentinel = new ListNode();
        temp = sentinel;
        temp.next = head;
        while(length>0){
            length--;
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return sentinel.next;
    }
}