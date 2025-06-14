class Solution {
    List<List<Integer>> answer;
    
    public List<List<Integer>> permute(int[] nums) {
        answer = new ArrayList<>();
        boolean[] usedNums = new boolean[nums.length];
        List<Integer> permutation = new ArrayList<>();
        dfs(permutation, nums, 0, usedNums);
        return answer;
    }

    private void dfs(List<Integer> permutation, int[] nums, int index, boolean[] usedNums){
        if(index == nums.length){
            answer.add(new ArrayList<>(permutation));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!usedNums[i]){
                usedNums[i] = true;
                permutation.add(nums[i]);
                dfs(permutation, nums, index+1, usedNums);
                permutation.remove(permutation.size()-1);
                usedNums[i] = false;
            }
        }
    }
}