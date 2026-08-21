class Solution {
    List<List<Integer>> answer;
    public List<List<Integer>> subsets(int[] nums) {
        answer = new ArrayList<>();
        findSubsets(0, nums, new ArrayList<>());
        return answer;
    }

    private void findSubsets(int idx, int[] nums, List<Integer> subset){
        answer.add(new ArrayList<>(subset));
        for(int i=idx;i<nums.length;i++){
            subset.add(nums[i]);
            findSubsets(i+1, nums, subset);
            subset.remove(subset.size()-1);
        }
    }
}