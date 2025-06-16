class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        doSubset(subset, 0, nums, answer);
        return answer;
    }

    private void doSubset(List<Integer> subset, int index, int[] nums, List<List<Integer>> answer){
        answer.add(new ArrayList<>(subset));
        for(int i=index;i<nums.length;i++){
            subset.add(nums[i]);
            doSubset(subset, i+1, nums, answer);
            subset.remove(subset.size()-1);
        }
    }
}