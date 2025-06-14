class Solution {
    List<List<Integer>> answer;
    public List<List<Integer>> subsets(int[] nums) {
        answer = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, subset, 0);
        return answer;
    }
    private void dfs(int[] nums, List<Integer> subset, int index){
        if(index == nums.length){
            answer.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[index]);
        dfs(nums, subset, index+1);
        subset.remove(subset.size()-1);
        dfs(nums, subset, index+1);
    }
}