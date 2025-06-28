class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for(int num: nums){
            numSet.add(num);
        }
        int count = 0;
        int maxCount = Integer.MIN_VALUE;
        for(int num: numSet){
            count = 0;
            if(!numSet.contains(num-1)){
                while(numSet.contains(num+1)) {
                    count++;
                    num++;
                }
            }
            maxCount=Math.max(maxCount, count);
        }
        return maxCount == Integer.MIN_VALUE ? 0: maxCount+1;
    }
}