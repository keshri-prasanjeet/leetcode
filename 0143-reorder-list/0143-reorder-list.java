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
    public void reorderList(ListNode head) {

        if(head == null || head.next == null) return;
        ListNode turtle = head;
        ListNode hare = head;

        while(hare.next!=null && hare.next.next != null){
            turtle = turtle.next;
            hare = hare.next.next;
        }

        ListNode secHead = reverseList(turtle.next);
        ListNode firHead = head;
        turtle.next = null;//cutting the list

        ListNode sentinel = new ListNode();
        ListNode temp = sentinel;

        while(firHead!=null || secHead!=null){
            if(firHead!=null){
                temp.next = firHead;
                firHead = firHead.next;
                temp = temp.next;
            }

            if(secHead!=null){
                temp.next = secHead;
                secHead = secHead.next;
                temp = temp.next;
            }
        }

    }

    private ListNode reverseList(ListNode halfHead){
        if(halfHead == null) return halfHead;

        ListNode prev = null;
        ListNode curr = halfHead;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}