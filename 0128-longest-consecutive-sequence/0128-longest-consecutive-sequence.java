class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        int longestConSeq = 0;
        for(int num:nums){
            numSet.add(num);
        }

        return numSet.stream()
                .filter(num -> !numSet.contains(num-1))
                .mapToInt(num -> {
                    int search = num;
                    int count = 0;

                    while(numSet.contains(search)){
                        search++;
                        count++;
                    }

                    return count;
                })
                .max()
                .orElse(0);
    }
}