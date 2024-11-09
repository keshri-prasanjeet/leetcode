class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> allSubsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, allSubsets, subset, 0);
        return allSubsets;
    }

    private void dfs(int[] nums, List<List<Integer>> allSubsets, List<Integer> subset, int index){
        if(index == nums.length){
            allSubsets.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[index]);
        dfs(nums, allSubsets, subset, index+1);
        subset.remove(subset.size()-1);
        
        while(index + 1 < nums.length && nums[index] == nums[index+1]){
            index++;
        }

        dfs(nums, allSubsets, subset, index +1);

    }
}