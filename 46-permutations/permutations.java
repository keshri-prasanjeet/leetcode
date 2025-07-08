class Solution {
    List<List<Integer>> answer;
    public List<List<Integer>> permute(int[] nums) {
        answer = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        boolean[] usedNums = new boolean[nums.length];
        findPermutations(nums, permutation, usedNums);
        return answer;
    }

    private void findPermutations(int[] nums, List<Integer> permutation, boolean[] usedNums){
        if(permutation.size() == nums.length){
            answer.add(new ArrayList<>(permutation));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!usedNums[i]){
                permutation.add(nums[i]);
                usedNums[i] = true;
                findPermutations(nums, permutation, usedNums);
                permutation.remove(permutation.size()-1);
                usedNums[i] = false;
            }
        }
    }
}