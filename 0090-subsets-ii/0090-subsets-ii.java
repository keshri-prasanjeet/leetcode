class Solution {
    List<List<Integer>> answer;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        answer = new ArrayList<>();
        Arrays.sort(nums);
        findAllSubsets(nums, new ArrayList<>(), 0);
        return answer;
    }

    private void findAllSubsets(int[] nums, List<Integer> subset, int idx){
        // if(idx == nums.length) return;

        answer.add(new ArrayList<>(subset));

        for(int i=idx;i<nums.length;i++){
            if(i > idx && nums[i] == nums[i-1]) continue;
            subset.add(nums[i]);
            findAllSubsets(nums, subset, i+1);
            subset.remove(subset.size()-1);
        }
    }
}