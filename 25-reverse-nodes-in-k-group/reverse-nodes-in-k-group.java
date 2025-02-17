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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        ListNode pointer = dummy;
        Stack<ListNode> nodeGroup = new Stack<>();
        dummy.next = head;
        ListNode start = dummy;
        ListNode curr = head;
        ListNode nextStart = null;
        while(curr!=null){
            int l = 0;
            while(curr!= null && l<k){
                nodeGroup.push(curr);
                curr = curr.next;
                l++;
            }
            if(curr==null) break;
            while(!nodeGroup.isEmpty()){
                pointer.next = nodeGroup.pop();
                pointer = pointer.next;
            }
            pointer.next = curr;
        }
        if(nodeGroup.size() == k){
            // System.out.println("pointer at " + pointer.val);
            while(!nodeGroup.isEmpty()){
                pointer.next = nodeGroup.pop();
                pointer = pointer.next;
                // System.out.println("Now pointer at " + pointer.val);
            }
            pointer.next = null;
        }
        
        // System.out.println("dummy is " + dummy.next.next.val);
        return dummy.next;
    }
}