class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for(int num: nums){
            numSet.add(num);
        }
        int count = 0;
        int maxCount = 0;
        for(int num: numSet){
            count = 1;
            if(!numSet.contains(num-1)){
                while(numSet.contains(num+1)) {
                    count++;
                    num++;
                }
            }
            maxCount=Math.max(maxCount, count);
        }
        return maxCount;
    }
}