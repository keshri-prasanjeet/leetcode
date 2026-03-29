class Solution {
    List<List<Integer>> answer;
    public List<List<Integer>> subsets(int[] nums) {
        answer = new ArrayList<>();
        findSubsets(nums, 0, new ArrayList<>());
        return answer;
    }

    private void findSubsets(int[] nums, int idx, List<Integer> subset){
        answer.add(new ArrayList<>(subset));
        for(int i=idx;i<nums.length;i++){
            subset.add(nums[i]);
            findSubsets(nums, i+1, subset);
            subset.remove(subset.size()-1);
        }
    }
}