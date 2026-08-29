/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode turtle = head;
        ListNode hare;
        if(turtle.next!=null) hare = turtle.next;
        else return false;
        while(hare!=null){
            if(hare == turtle) return true;
            turtle = turtle.next;
            hare = hare.next;
            if(hare!=null) hare = hare.next;
            else return false;
        }
        return false;
    }
}