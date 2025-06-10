class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        //need to combine the two arrays together into one
        //then sort them based on nums2
        int n = nums1.length;
        int[][] combinedArr = new int[n][2];
        for(int i=0;i<n;i++){
            combinedArr[i][0] = nums1[i];
            combinedArr[i][1] = nums2[i];
        }

        //0th index is the sum array
        //1st index is the multiply array

        Arrays.sort(combinedArr, (a,b) -> b[1] - a[1]); //sorting the array based on the nums2 arr

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long maxSubsequenceScore = 0;
        long sum = 0;
        for(int i = 0;i<n;i++){
            int num = combinedArr[i][0];
            int minVal = combinedArr[i][1];

            sum+=num;
            minHeap.add(num);

            if(minHeap.size() > k){
                sum-=minHeap.poll();
            }

            if(minHeap.size() == k){
                long maxVal = sum * minVal;
                maxSubsequenceScore = Math.max(maxSubsequenceScore, maxVal);
            }
        }
        return maxSubsequenceScore;
    }
}