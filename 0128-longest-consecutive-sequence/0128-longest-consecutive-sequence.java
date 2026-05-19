class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        int longestConSeq = 0;
        for(int num:nums){
            numSet.add(num);
        }
        return numSet.stream()
            .filter(num -> isStartOfSequence(numSet, num))
            .mapToInt(num -> countSequenceLength(numSet, num))
            .max()
            .orElse(0);
    }

    private boolean isStartOfSequence(Set<Integer> numSet, int num){
        return (!numSet.contains(num-1));
    }

    private int countSequenceLength(Set<Integer> numSet, int num){
        int count = 0;
        while(numSet.contains(num++)) count++;
        return count;
    }
}