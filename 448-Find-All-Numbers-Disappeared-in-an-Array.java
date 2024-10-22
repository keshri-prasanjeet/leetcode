class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();
        Set<Integer> numSet = new HashSet<>();
        for(int i:nums){
            numSet.add(i);
        }

        for(int i=1;i<=nums.length;i++){
            if(numSet.contains(i)==false) missingNumbers.add(i);
        }
        return missingNumbers;
    }
}