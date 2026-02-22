class Solution {
    List<List<Integer>> answer;
    public List<List<Integer>> permute(int[] nums) {
        answer = new ArrayList<>();
        boolean[] numSet = new boolean[nums.length];
        findPermutations(nums, numSet, new ArrayList<>());
        return answer;
    }

    private void findPermutations(int[] nums, boolean[] numSet, List<Integer> permutation){
        if(permutation.size() == nums.length){
            answer.add(new ArrayList<>(permutation));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(numSet[i] == false){
                numSet[i] = true;
                permutation.add(nums[i]);
                findPermutations(nums, numSet, permutation);
                numSet[i] = false;
                permutation.remove(permutation.size()-1);
            }
        }
    }
}