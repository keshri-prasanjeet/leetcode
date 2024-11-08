class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for(int num: nums){
            numSet.add(num);
        }
        int longestConsecutive = 0;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            int cur = nums[i];
            if(numSet.contains(cur-1) && !numSet.contains(cur+1)){
                count = 1;
                while(numSet.contains(cur-1)){
                    count++;
                    cur--;
                }
            }
            longestConsecutive = Math.max(longestConsecutive, count);
            count = 1;
        }

        return Math.max(longestConsecutive,count);
    }
}