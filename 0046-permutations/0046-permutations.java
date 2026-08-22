class Solution {
    List<List<Integer>> allPermutations;
    public List<List<Integer>> permute(int[] nums) {
        allPermutations = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), new boolean[nums.length]);
        return allPermutations;
    }

    private void backtrack(int[] nums, List<Integer> permutation, boolean[] memberCheck){
        if(permutation.size() == nums.length){
            allPermutations.add(new ArrayList<>(permutation));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(memberCheck[i]) continue;
            memberCheck[i] = true;
            permutation.add(nums[i]);
            backtrack(nums, permutation, memberCheck);
            permutation.remove(permutation.size()-1);
            memberCheck[i] = false;
        }
    }
}