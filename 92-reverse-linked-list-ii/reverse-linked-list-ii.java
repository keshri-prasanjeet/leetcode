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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // left and right are positions
        Stack<ListNode> rightStack = new Stack<>();
        ListNode leftPointer = head;
        ListNode rightPointer = head;
        int orgLeft = left;
        left--;
        // right--;
        while(left!=0){
            leftPointer = leftPointer.next;
            left--;
        }
        while(right>0){
            rightStack.push(rightPointer);
            // System.out.println("right pointer has " + rightPointer.val);
            // System.out.println("right is " + right);
            rightPointer = rightPointer.next;
            right--;
        }
        // System.out.println(leftPointer.val);
        int len = rightStack.size();
        len = len - orgLeft+1;
        System.out.println(len);
        len/=2;
        while(len > 0){
            len--;
            int leftVal = leftPointer.val;
            ListNode rightNode = rightStack.pop();
            leftPointer.val = rightNode.val;
            rightNode.val = leftVal;
            leftPointer = leftPointer.next;
        }
        return head;
    }
}