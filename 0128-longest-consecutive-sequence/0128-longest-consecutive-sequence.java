class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        int longestSeq = 0;
        for(int num: nums){
            numSet.add(num);
        }
        return numSet.stream()
        .filter(num -> isStartOfSequence.test(numSet, num))
        .mapToInt(num -> countSequenceLength.apply(numSet, num))
        .max()
        .orElse(0);
    }

    private BiPredicate<Set<Integer>, Integer> isStartOfSequence = (numSet, num) -> !numSet.contains(num-1);

    private BiFunction<Set<Integer>, Integer, Integer> countSequenceLength = (numSet, num) -> {
        int count = 0;
        while(numSet.contains(num++)) count++;
        return count;
    };

}