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
            while(!nodeGroup.isEmpty()){
                pointer.next = nodeGroup.pop();
                pointer = pointer.next;
            }
            pointer.next = null;
        }
        return dummy.next;
    }
}