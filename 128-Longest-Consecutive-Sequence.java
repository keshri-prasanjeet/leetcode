class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for(int num:nums){
            numSet.add(num);
        }
        int count = 0;
        int longestSequence = 0;
        for(int i=0;i<nums.length;i++){
            int cur = nums[i];
            count = 1;
            if(numSet.contains(cur-1) && !numSet.contains(cur+1)){
                while(numSet.contains(cur-1)){
                    count++;
                    cur--;
                }
                longestSequence = Math.max(count, longestSequence);
            }
            count = 1;
        }
        return Math.max(longestSequence,count);
    }
}