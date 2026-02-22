class Solution {
    List<List<Integer>> answer;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        answer = new ArrayList<>();
        Arrays.sort(nums);
        findSubsetsBottomUp(nums, 0, new ArrayList<>());
        return answer;
    }

    private void findSubsetsTopDown(int[] nums, int index, List<Integer> subset){
        answer.add(new ArrayList<>(subset));
        for(int i=index;i<nums.length;i++){
            if(i > index && nums[i] == nums[i-1]) continue;
            subset.add(nums[i]);
            findSubsetsTopDown(nums, i+1, subset);
            subset.remove(subset.size()-1);
        }
    }

    private void findSubsetsBottomUp(int[] nums, int index, List<Integer> subset){
        if(index == nums.length){
            answer.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[index]);
        findSubsetsBottomUp(nums, index+1, subset);
        subset.remove(subset.size()-1);

        int next = index+1;
        while(next < nums.length && nums[next] == nums[next-1]) next++;

        findSubsetsBottomUp(nums, next, subset);
    }
}