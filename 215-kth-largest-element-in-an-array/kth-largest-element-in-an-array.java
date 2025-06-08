class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> priorityQ = new PriorityQueue<>((a,b) -> b - a);
        for(int n: nums){
            priorityQ.offer(n);
        }
        // int rem = nums.length - k;
        int ans = 0;
        while(k-- > 0){
            ans = priorityQ.poll();
        }
        return ans;
    }
}