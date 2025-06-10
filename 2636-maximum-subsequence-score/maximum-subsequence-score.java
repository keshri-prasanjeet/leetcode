class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        //consolidate the two arrays into one so that we cant sort them together
        int n = nums1.length;
        int[][] nums = new int[n][2];
        for(int i=0;i<n;i++){
            nums[i][0] = nums1[i];
            nums[i][1] = nums2[i];
        }

        //sort the nums array based on nums2 val in decending order

        Arrays.sort(nums, (a,b) -> b[1] - a[1]);//sorted in decending order

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();//pq to store only least k nums in queue

        long sum = 0;
        long maxScore = 0;
        for(int i=0;i<n;i++){
            int nums1Val = nums[i][0];
            int nums2Val = nums[i][1];

            sum+=nums1Val;
            minHeap.offer(nums1Val);

            if(minHeap.size() > k){
                sum-=minHeap.poll();
            }

            if(minHeap.size() == k){
                long score = sum * nums2Val;
                maxScore = Math.max(maxScore, score);
            }
        }
        return maxScore;
    }
}