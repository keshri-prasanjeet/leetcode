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
        if(head == null || head.next == null) return false;
        ListNode tortoise = head;
        ListNode hare = head;
        do{
            tortoise = tortoise.next;
            hare = hare.next;
            if(hare!= null) {
                hare= hare.next;
            }
            else return false;
        }
        while(tortoise!= null && hare!= null && tortoise!=hare);
        if((tortoise == null) || (hare == null)) return false;
        return true;
    }
}