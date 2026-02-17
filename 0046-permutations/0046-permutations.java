class Solution {
    List<List<Integer>> answer;
    public List<List<Integer>> permute(int[] nums) {
        answer = new ArrayList<>();
        findPermutations(nums, new ArrayList<>(), new boolean[nums.length]);
        return answer;
    }

    private void findPermutations(int[] nums, List<Integer> permutation, boolean[] usedNums){
        if(permutation.size() == nums.length){
            answer.add(new ArrayList<>(permutation));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(usedNums[i]==false){
                permutation.add(nums[i]);
                usedNums[i] = true;
                findPermutations(nums, permutation, usedNums);
                usedNums[i] = false;
                permutation.remove(permutation.size()-1);
            }
        }
    }
}