class Solution {
    List<List<Integer>> answer;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        answer = new ArrayList<>();
        findSubsets(nums, new ArrayList<>(), 0);
        return answer;
    }
    private void findSubsets(int[] nums, List<Integer> subset, int idx){
        if(idx == nums.length){
            answer.add(new ArrayList<>(subset));
            return;
        }
        int nextIdx = idx+1;
        while(nextIdx < nums.length && nums[nextIdx] == nums[idx]){
            nextIdx++;
        }
        findSubsets(nums, subset, nextIdx);
        subset.add(nums[idx]);
        findSubsets(nums, subset, idx+1);
        subset.remove(subset.size()-1);
    }
}