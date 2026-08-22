class Solution {
    List<List<Integer>> noDuplicatesSubset;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        noDuplicatesSubset = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), 0);
        return noDuplicatesSubset;
    }

    private void backtrack(int[] nums, List<Integer> subset, int start){
        noDuplicatesSubset.add(new ArrayList<>(subset));
        for(int i=start; i< nums.length;i++){
            if(i > start && nums[i] == nums[i-1]) continue;
            subset.add(nums[i]);
            backtrack(nums, subset, i+1);
            subset.remove(subset.size()-1);
        }
    }
}