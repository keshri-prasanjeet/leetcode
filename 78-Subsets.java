class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, answer, subset, 0);
        return answer;
    }

    private void dfs(int[] nums, List<List<Integer>> answer, List<Integer> subset, int index){
        if(index == nums.length){
            answer.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[index]);
        dfs(nums, answer, subset, index+1);
        subset.remove(subset.size()-1);
        dfs(nums, answer, subset, index+1);
    }
}