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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-200);
        ListNode pointer = dummy;
        if(head== null || head.next == null) return head;
        ListNode p1 = head;
        ListNode p2 = head.next;
        while(p1!=null){
            if(p2==null) return dummy.next;
            // System.out.println("p1 is " + p1.val + " p2 is " + p2.val);
            if(p1.val != p2.val){
                pointer.next = p1;
                pointer = pointer.next;
                p1 = p1.next;
                p2 = p2.next;
            }
            else{
                while(p2!=null && p1.val == p2.val){
                    p2 = p2.next;
                }
                if(p2==null){
                    pointer.next = null;
                    return dummy.next;
                }
                p1 = p2;
                p2 = p2.next;
                if(p2==null){
                    pointer.next = p1;
                    return dummy.next;
                }
            }
        }
        return dummy.next;
    }
}