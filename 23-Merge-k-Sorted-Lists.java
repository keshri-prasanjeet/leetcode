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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while(true){
            int choice = -1;
            ListNode nexx = null;
            for(int i = 0;i<lists.length;i++){
                if(nexx==null){
                    if(lists[i]!=null){
                        nexx = lists[i];
                        choice = i;
                    }
                }
                else{
                    if(lists[i]!=null){
                        if(nexx.val > lists[i].val){
                            nexx = lists[i];
                            choice = i;
                        }
                    }
                }
                
            }
            if(choice!=-1){
                temp.next = nexx;
                temp = temp.next;
                lists[choice] = lists[choice].next;
            }
            else{
                break;
            }
        }
        return dummy.next;
    }
}