class Solution {
    List<List<Integer>> answer;
    public List<List<Integer>> permute(int[] nums) {
        answer = new ArrayList<>();
        findPermutations(nums, new ArrayList<>(), new boolean[nums.length]);
        return answer;
    }

    private void findPermutations(int[] nums, List<Integer> permutation, boolean[] numSet){
        if(permutation.size() == nums.length){
            answer.add(new ArrayList<>(permutation));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(numSet[i] == false){
                permutation.add(nums[i]);
                numSet[i] = true;
                findPermutations(nums, permutation, numSet);
                numSet[i] = false;
                permutation.remove(permutation.size()-1);
            }
        }
    }
}