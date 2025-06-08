class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> priorityQ = new PriorityQueue<>();
        for(int n: nums){
            priorityQ.offer(n);
        }
        int rem = nums.length - k;
        int ans = 0;
        while(rem-- >= 0){
            ans = priorityQ.poll();
        }
        return ans;
    }
}