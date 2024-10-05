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

    public ListNode sortList(ListNode node){
        if(node==null || node.next==null){
            return node;
        }

        ListNode fast = node.next;
        ListNode slow = node;

        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode splitHead = slow.next;
        slow.next = null;

        ListNode leftSorted = sortList(node);
        ListNode rightSorted= sortList(splitHead);

        return mergeList(leftSorted, rightSorted);
    }

    private ListNode mergeList(ListNode left, ListNode right){
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(left!=null && right!=null){
            if(left.val < right.val){
                temp.next = left;
                left=left.next;
            }
            else{
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }

        while(left!=null){
            temp.next = left;
            left = left.next;
            temp = temp.next;
        }

        while(right!=null){
            temp.next = right;
            right = right.next;
            temp = temp.next;
        }

        return dummy.next;
    }
}