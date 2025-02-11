class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for(int num:nums){
            numSet.add(num);
        }
        int longestConsecutive = 0;
        for(int num:numSet){
            if(!numSet.contains(num-1)){
                int currentNum = num;
                int count = 1;
                while(numSet.contains(++currentNum)){
                    count++;
                }
                longestConsecutive = Math.max(longestConsecutive, count);
            }
        }
        return longestConsecutive;
    }
}