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
    public ListNode partition(ListNode head, int x) {
        ListNode pointer = head;
        List<ListNode> nodeList = new ArrayList<>();
        while(pointer!=null){
            if(pointer.val < x){
                nodeList.add(pointer);
            }
            pointer = pointer.next;
        }
        pointer = head;
        while(pointer!=null){
            if(pointer.val >= x){
                nodeList.add(pointer);
            }
            pointer = pointer.next;
        }
        ListNode sentinel = new ListNode();
        pointer = sentinel;
        for(int i=0;i<nodeList.size();i++){
            pointer.next = nodeList.get(i);
            pointer = pointer.next;
        }
        pointer.next = null;
        return sentinel.next;
    }
}