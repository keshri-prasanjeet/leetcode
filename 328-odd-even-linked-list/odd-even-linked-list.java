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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return head;
        ListNode oddHead = head;
        ListNode evenHead= head.next;

        ListNode oddTemp = oddHead;
        ListNode evenTemp= evenHead;
        ListNode lastOdd = null;

        while(oddTemp != null && evenTemp != null){
            if(oddTemp.next!=null){
                oddTemp.next = oddTemp.next.next;
                if(oddTemp.next != null) lastOdd = oddTemp.next;
                oddTemp = oddTemp.next;
            }

            if(evenTemp.next != null){
                evenTemp.next = evenTemp.next.next;
                evenTemp = evenTemp.next;
            }
        }

        lastOdd.next = evenHead;
        return oddHead;

    }
}