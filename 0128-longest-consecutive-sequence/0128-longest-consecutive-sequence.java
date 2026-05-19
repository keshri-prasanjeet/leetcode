class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        int count = 0;
        int longestConSeq = 0;
        for(int num:nums){
            numSet.add(num);
        }
        for(int num:numSet){
            if(!numSet.contains(num-1)){
                // a potential start of the lognest sub sequence
                int search = num;
                count = 0;
                while(numSet.contains(search++)){
                    count++;
                }
                longestConSeq = Math.max(longestConSeq, count);
            }
        }
        return longestConSeq;
    }
}