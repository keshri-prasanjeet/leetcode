class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> allSubsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(allSubsets, subset, 0, nums);
        return allSubsets;
    }
    private void dfs(List<List<Integer>> allSubsets, List<Integer> subset, int index, int[] nums){
        if(index == nums.length){
            allSubsets.add(new ArrayList<>(subset));
            return;
        }

        //do the choice of adding first
        subset.add(nums[index]);
        dfs(allSubsets, subset, index+1, nums);
        subset.remove(subset.size() -1);
        dfs(allSubsets, subset, index+1, nums);
    }
}