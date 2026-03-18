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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode();

        ListNode cur = dummy;

        //only when cur was pointing to dummy
        //the next of dummy was changes

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                //this will come before
                cur.next = list1;//first time dummy.next = list1
                list1 = list1.next;
            } else {
                cur.next = list2;//first time dummy.next = list2
                list2 = list2.next;
            }
            cur = cur.next;
        }

        // whatever is remaining in list1 or list2 just append it

        if(list1!=null){
            cur.next = list1;
        }

        if(list2!=null){
            cur.next = list2;
        }

        return dummy.next; // returning an address


        // 1,2,3,4,5,6
        // 

        // 1,3,5-------
        // 1,2,4,6,7,8,9,0
        //.       ^
    }
}