class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int len = nums1.length;
        int [][] nums = new int[len][2];
        long maxScore = 0;
        long score = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0;i<len;i++){
            nums[i][0] = nums1[i];
            nums[i][1] = nums2[i];
        }//consolidate into one array

        Arrays.sort(nums, (a,b) -> b[1] - a[1]);
        //sort arrording to nums2
        long sum = 0;
        for(int i=0;i<len;i++){
            int nums1Val = nums[i][0];
            int nums2Val = nums[i][1];

            sum+=nums1Val;
            minHeap.offer(nums1Val);
            if(minHeap.size() > k){
                sum-=minHeap.poll();
            }

            if(minHeap.size() == k){
                score = sum * nums2Val;
                maxScore = Math.max(maxScore, score);
            }
            
        }
        return maxScore;
    }
}