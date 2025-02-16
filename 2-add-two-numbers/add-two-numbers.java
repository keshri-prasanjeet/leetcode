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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        int carry = 0;
        ListNode dummy = new ListNode();
        ListNode pointer = dummy;
        while(l1 != null || l2!=null){
            if(l1!=null){
                sum += l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum += l2.val;
                l2=l2.next;
            }
            carry = sum / 10;
            sum = sum % 10;
            pointer.next = new ListNode();
            pointer = pointer.next;
            pointer.val = sum;
            sum = carry;
        }
        if(carry!=0) pointer.next = new ListNode(carry);
        return dummy.next;
    }
}