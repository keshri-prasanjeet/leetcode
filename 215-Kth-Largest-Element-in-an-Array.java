class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int i:nums){
            pq.offer(i);
        }
        int head=0;
        while(k>0){
            head = pq.poll();
            k--;
        }
        return head;
    }
}