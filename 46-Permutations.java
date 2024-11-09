class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> allPermutation = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, used, allPermutation, permutation);
        return allPermutation;
    }

    private void dfs(int[] nums, boolean[] used, List<List<Integer>> allPermutation, List<Integer> permutation){
        if(permutation.size()==nums.length){
            allPermutation.add(new ArrayList<>(permutation));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!used[i]){
                permutation.add(nums[i]);
                used[i] = true;
                dfs(nums, used, allPermutation, permutation);
                permutation.remove(permutation.size()-1);
                used[i] = false;
            }
            
        }
        return;
    }
}