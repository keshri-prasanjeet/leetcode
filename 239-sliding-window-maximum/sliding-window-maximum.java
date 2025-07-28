class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int right = 0;
        int[] result = new int[nums.length - k +1];
        while(right < nums.length){
            while(!dq.isEmpty() && dq.peekFirst() < right - k +1)
                dq.pollFirst();
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[right])
                dq.pollLast();
            dq.offerLast(right);
            if(right >= k-1){
                result[right - k +1] = nums[dq.peekFirst()];
            }
            right++;
        }
        return result;
    }
}